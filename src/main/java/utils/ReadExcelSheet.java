package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReadExcelSheet {
    public static final String filePath = "resources/excel.xlsx";
    public static final String sheetName = "Sheet1";

    public static Object[][] getDataFromExcel(String filePath, String sheetName, String[] requiredColumns, Integer executionLimit) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            if (executionLimit != null) {rowCount = 2;}

            Row headerRow = sheet.getRow(0);
            Map<String, Integer> headerMap = new HashMap<>();
            for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
                String headerName = headerRow.getCell(j).getStringCellValue();
                headerMap.put(headerName, j);
            }

            Object[][] data = new Object[rowCount - 1][requiredColumns.length];
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < requiredColumns.length; j++) {
                    int colIndex = headerMap.get(requiredColumns[j]);
                    data[i-1][j] = row.getCell(colIndex).toString();
                }
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
