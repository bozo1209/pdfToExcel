package gui.buttons;

import excel.SaveAccountsAndAmountsInExcel;
import gui.listModel.MyFileListModel;
import pdf.ExtractsAccountsAndAmounts;
import utilities.interfaces.CustomPair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class WriteToExcelButton extends JButton {

    private final String CANCEL = "CANCEL";

    public WriteToExcelButton(){
        String BUTTON_TEXT = "Write to pdf";
        this.setText(BUTTON_TEXT);
        this.addActionListener(this::buttonAction);
    }

    private void buttonAction(ActionEvent event){
        String location = getLocationToSave();
        SaveAccountsAndAmountsInExcel saveAccountsAndAmountsInExcel = new SaveAccountsAndAmountsInExcel();
        ArrayList<CustomPair<String, BigDecimal>> accountsAndAmountsList = getAccountsAndAmountsList(MyFileListModel.getInstance().toArray());
        if (!location.equals(CANCEL)){
            saveAccountsAndAmountsInExcel.saveInExcel(accountsAndAmountsList, location);
            saveAccountsAndAmountsInExcel.openExcel(location);
            MyFileListModel.removeElements();
        }
    }

    private String getLocationToSave(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile().getAbsolutePath() + FileSystems.getDefault().getSeparator();
        }
        return CANCEL;
    }

    private ArrayList<CustomPair<String, BigDecimal>> getAccountsAndAmountsList(File[] files){
        ExtractsAccountsAndAmounts extractsAccountsAndAmounts = new ExtractsAccountsAndAmounts();
        return extractsAccountsAndAmounts.getAccountsAndAmountsList(files);
    }
}
