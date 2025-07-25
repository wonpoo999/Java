package absoluteTest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelSaver {
    public static void saveExcelFile(File file, String title, String content) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("기록");

            Row titleRow = sheet.createRow(0);
            titleRow.createCell(0).setCellValue("제목");
            titleRow.createCell(1).setCellValue("내용");

            String[] lines = content.split("\n");
            for (int i = 0; i < lines.length; i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(title);
                row.createCell(1).setCellValue(lines[i]);
            }

            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            System.out.println("❌ Excel 저장 실패: " + e.getMessage());
        }
    }
}
