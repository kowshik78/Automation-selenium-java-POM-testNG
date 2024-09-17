package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadExcelSheet {

    public static Object[][] getDataFromExcel(String filePath, String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            Object[][] data = new Object[rowCount - 1][3];

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                data[i - 1][0] = row.getCell(0).toString();
                data[i - 1][1] = row.getCell(1).toString();
                data[i - 1][2] = row.getCell(2).toString();
            }
            return data;
        }
    }

    public static void writeEmailToExcel(String filePath, String sheetName, int rowNumber, String email) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNumber);

            Cell emailCell = row.createCell(3);
            emailCell.setCellValue(email);
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }
        }
    }
}
