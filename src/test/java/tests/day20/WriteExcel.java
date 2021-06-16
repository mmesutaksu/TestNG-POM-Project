package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.*;

public class WriteExcel {

    @Test
    public void test01() throws IOException {
        String path = "src/test/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        workbook.getSheetAt(0).getRow(0).createCell(4).setCellValue("NUFUS");
        workbook.getSheetAt(0).getRow(0).createCell(4).setCellValue("100000");
        workbook.getSheetAt(0).getRow(0).createCell(4).setCellValue("10000");
        workbook.getSheetAt(0).getRow(0).createCell(4).setCellValue("2100000");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);


    }
}
