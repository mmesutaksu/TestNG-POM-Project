package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.Driver;

public class C1_WebTable {
     /*
    login() metodun oluşturun ve oturum açın.
    ● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
                ○ Username : manager
                ○ Password : Manager1!
    ● table() metodu oluşturun
                ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
                ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    ● printRows() metodu oluşturun //tr
                ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
                ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
                ○ 4.satirdaki(row) elementleri konsolda yazdırın.
     */

    @Test
    public void table(){
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        koalaResortPage.koalaResortLogin();

        // //tbody//tr[1]//td  Tablonun 1. satirindaki data sayisini veriyor. Toplam 9 webelementi bulunuyor

        System.out.println("Tablodaki sütun sayisi = "+koalaResortPage.birinciSatirDatalar.size());

        System.out.println();

        for (WebElement w : koalaResortPage.sütunBasliklariListesi) {
            System.out.println(w.getText());
        }

        System.out.println();

        System.out.println(koalaResortPage.tbodyWE.getText());  // Tüm body'i WebElemente atayip gettext ile yazdirdik
        // Bu sekilde tüm body önümüze serilir ancak satir sütun yada sayica ayirmak mümkün olmaz.
        // Ancak her seyi görmek icin kullanilabilir.

        System.out.println();

        System.out.println("Tablonun Body'sinde bulunan tüm hücre sayisi = " +koalaResortPage.bodydekiTümCellListesi.size());

        Driver.closeDriver();
    }

    @Test
    public void getRows(){
        /*
        ● printRows() metodu oluşturun //tr
                ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
                ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
                ○ 4.satirdaki(row) elementleri konsolda yazdırın.
         */
        KoalaResortPage koalaResortPage = new KoalaResortPage();

        koalaResortPage.koalaResortLogin();

        System.out.println(koalaResortPage.tümSatirlarListesi.size());

        for (WebElement w : koalaResortPage.bodydekiTümCellListesi) {
            System.out.println(w.getText());
        }

        System.out.println(koalaResortPage.tümSatirlarListesi.get(3).getText());

        System.out.println();

        // Page sayfasinda olusturdugumuz method ile daha sade ve dinamik yazdiralim
        // 7. Satiri yazdiralim

        koalaResortPage.istenilenSatiriYazdir(4);

    }
}
