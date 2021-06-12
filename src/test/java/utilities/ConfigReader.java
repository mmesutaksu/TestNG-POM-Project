package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // 1- Properties objesi olusturulur
    // Projenin her yerinden ulasabilmek icin static yaptik
    // Class disindan ulasilmamasi icin private yaptik(opsiyonel)

    static private Properties properties;

    static{
        String path = "src/configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);

            // Bu class calistiginda ilk önce static block calisir
            // tek bir islem yapar
            // fileInputStream objesi calisacak ve okudugu datalari properties objesine yükleyecek

            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){

        String value = properties.getProperty(key);

        return value;
    }


}
