package tests.day19ExcelAutomation;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {

        String excelPath = "src/test/resources/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(excelPath);

        // Ecel oldugu icin workBook olusturmamiz gerekiyor
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Excel'in yapisi geregi WorkBook'un icinde sheet secmeliyiz
        Sheet sheet = workbook.getSheet("Sayfa1");

        // Sayfa'dan sonra satira ulasmamiz gerekiyor
        Row row = sheet.getRow(4);  // index ile seciliyor yani 0'dan basliyor

        // Satirdan sonra cell secmemiz gerekiyor.(hücre)
        Cell cell = row.getCell(3);

        //**** Su anda cell variable'inin icinde workbook/Sayfa1/5.satir/4.cell bilgisine ulastik.

        System.out.println(cell);
    }

    @Test
    public void readExcel2() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(ConfigReader.getProperty("excel_path"));

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Cell cell = workbook.getSheet(ConfigReader.
                getProperty("excel_sheet_adi")).
                getRow(Integer.parseInt(ConfigReader.getProperty("excel_row_index"))).
                getCell(Integer.parseInt(ConfigReader.getProperty("excel_cell_index")));

        System.out.println(cell);
        System.out.println(cell.toString().substring(0,1));

        System.out.println("--------------------------------------");
        // son satirin index'ini verir, satir sayisini bulmak icin kullaniriz
        System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sheet_adi")).getLastRowNum());

        System.out.println("--------------------------------------");
        // icinde bilgi iceren satir sayisini verir. index ile vermez normal rakami döndürür
        System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sheet_adi")).getPhysicalNumberOfRows());


        System.out.println("--------------------------------------");
        // 2. sayfadaki degerleri bulalim
        System.out.println(workbook.getSheetAt(1).getLastRowNum());
        System.out.println(workbook.getSheetAt(1).getPhysicalNumberOfRows());


        System.out.println("--------------------------------------");
        // Excel'deki tüm ülkelerin türkce olanlarini yazdirin

        for (int i = 0; i < workbook.getSheetAt(0).getLastRowNum(); i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(2));
        }

        // Exceldeki tüm datalari class'imiza almak istersek
        // Bunun icin datalari bir java objesine eklememiz gerekir

        // Bu excel'i map a depolayabiliriz
        // Map'a depolamak icin sütunlardan birini KEY
        // digerlerini ise vir gül ile ayirarak String value atayablirim

        Map<String, String> ülkelerMap = new HashMap<>();
        String key = "";
        String value = "";

        for (int i = 1; i <= workbook.getSheetAt(0).getLastRowNum(); i++) {
            key =workbook.getSheetAt(0).getRow(i).getCell(0).toString();

            value = workbook.getSheetAt(0).getRow(i).getCell(1).toString() + ", " +
                    workbook.getSheetAt(0).getRow(i).getCell(2).toString() + ", " +
                    workbook.getSheetAt(0).getRow(i).getCell(3).toString();

            ülkelerMap.put(key,value);
        }

        System.out.println(ülkelerMap);


        fileInputStream.close();
        workbook.close();

    }
}
