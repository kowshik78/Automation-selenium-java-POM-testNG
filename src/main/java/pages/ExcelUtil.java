package pages;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtil {

    private Workbook workbook;
    private Sheet sheet;
    private Iterator<Row> rows;

    public ExcelUtil(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        rows = sheet.iterator();
    }

    public String[] getRowData(int rowIndex) {
        Row row = sheet.getRow(rowIndex);
        String[] data = new String[row.getPhysicalNumberOfCells()];
        Iterator<Cell> cells = row.iterator();
        int i = 0;
        while (cells.hasNext()) {
            Cell cell = cells.next();
            data[i++] = cell.getStringCellValue();
        }
        return data;
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public void close() throws IOException {
        workbook.close();
    }
}
