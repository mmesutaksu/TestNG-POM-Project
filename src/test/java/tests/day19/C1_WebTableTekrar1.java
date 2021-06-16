package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.Driver;

public class C1_WebTableTekrar1 {

    //● printCells() metodu oluşturun //td
    //	○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    //	○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    //● printColumns() metodu oluşturun
    //	○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //	○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    //	○ 5.column daki elementleri konsolda yazdırın.

    @Test
    public void printCells(){
        KoalaResortPage koalaResortPage = new KoalaResortPage();

        koalaResortPage.koalaResortLogin();
        //	○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //	○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

        System.out.println(koalaResortPage.bodydekiTümCellListesi.size()+"\n");

        for (WebElement w : koalaResortPage.bodydekiTümCellListesi) {
            System.out.println(w.getText());
        }
        Driver.closeDriver();
    }

    @Test
    public void printColumns(){
        KoalaResortPage koalaResortPage = new KoalaResortPage();

        koalaResortPage.koalaResortLogin();
        //	○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        //	○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        //	○ 5.column daki elementleri konsolda yazdırın.

        System.out.println(koalaResortPage.sütunBasliklariListesi.size());

        koalaResortPage.sütunYazdir(5);

        for (int i = 1; i < koalaResortPage.sütunBasliklariListesi.size(); i++) {
            koalaResortPage.sütunYazdir(i);
        }
        Driver.closeDriver();
    }
}
