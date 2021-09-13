package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.interfaces.CustomPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SaveAccountsAndAmountsInExcel {

    public void saveInExcel(ArrayList<CustomPair<String, BigDecimal>> accountsAndAmountsList, String path){
        Workbook workbook = addValuesToExcel(createExcel(), accountsAndAmountsList);
        saveExcel(path, workbook);
    }


    private Workbook createExcel(){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("accounts");
        Row header = sheet.createRow(0);
        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Account");
        headerCell = header.createCell(1);
        headerCell.setCellValue("Amount");
        return workbook;
    }

    private Workbook addValuesToExcel(Workbook workbook, ArrayList<CustomPair<String, BigDecimal>> accountsAndAmountsList){
        Sheet sheet = workbook.getSheet("accounts");
        Row row;
        Cell cell;
        FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
        int rowNumber = 1;
        for (CustomPair<String, BigDecimal> pair : accountsAndAmountsList){
            row = sheet.createRow(rowNumber);
            cell = row.createCell(0);
            cell.setCellValue("'" + pair.getAccount());
            cell = row.createCell(1);
            cell.setCellValue(pair.getAmount().doubleValue());
//            cell.setCellFormula("VALUE(" + pair.getAmount() + ")");
//            formulaEvaluator.evaluate(cell);
            rowNumber++;
        }
        formulaEvaluator.evaluateAll();
        formulaEvaluator.clearAllCachedResultValues();
        return workbook;
    }

    private void saveExcel(String path, Workbook workbook){
        try(FileOutputStream outputStream = new FileOutputStream(new File(path + "temp" + LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "") + ".xlsx"))) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
