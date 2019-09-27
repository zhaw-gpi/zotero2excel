package ch.zhaw.iwi.zotero2excel.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.iwi.zotero2excel.models.Charsets;
import ch.zhaw.iwi.zotero2excel.repositories.CharsetsRepository;

/**
 * ExcelWriter
 */
@Component
public class ExcelWriter {

    @Autowired
    private CharsetsRepository charsetsRepository;

    public void writeCharsets() throws IOException {
        // Neue Arbeitsmappe
        Workbook workbook = new XSSFWorkbook();

        try {
            // Row-Number initialisieren
            Integer rowNumber = 0;

            // Neues Tabellenblatt
            Sheet sheet = workbook.createSheet("Charsets");

            // Zellformatierungstyle für Titelzellen festlegen
            Font headerFont = workbook.createFont();
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setFontName("Arial");
            
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());  
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);    

            // Zellformatierungstyle für normale Zellen festlegen
            Font normalFont = workbook.createFont();
            normalFont.setFontHeightInPoints((short) 12);
            normalFont.setFontName("Arial");

            CellStyle normalStyle = workbook.createCellStyle();
            normalStyle.setFont(normalFont);

            // Spaltenbreiten festlegen
            sheet.setColumnWidth(0, 1000);
            sheet.setColumnWidth(1, 8000);

            // Titelzeile hinzufügen und formatieren
            Row rowHeader = sheet.createRow(rowNumber);
            Cell cell = rowHeader.createCell(0);
            cell.setCellValue("ID");
            cell.setCellStyle(headerStyle);

            cell = rowHeader.createCell(1);
            cell.setCellValue("Bezeichnung");
            cell.setCellStyle(headerStyle);

            // Datenzeilen hinzufügen und formatieren
            for (Charsets charsets : charsetsRepository.findAll()) {
                rowNumber++;
                Row dataRow = sheet.createRow(rowNumber);
                cell = dataRow.createCell(0);
                cell.setCellValue(charsets.getCharsetID());
                cell.setCellStyle(normalStyle);

                cell = dataRow.createCell(1);
                cell.setCellValue(charsets.getCharset());
                cell.setCellStyle(normalStyle);
            }

            // Workbook exportieren
            File curDir = new File(".");
            String curDirPath = curDir.getAbsolutePath();
            String workbookPath = curDirPath.substring(0, curDirPath.length() - 1) + "Charsets.xlsx";

            FileOutputStream fileOutputStream = new FileOutputStream(workbookPath);
            workbook.write(fileOutputStream);
        } finally {
            if(workbook != null){
                workbook.close();
            }
        }
    }
}