package gui.buttons;

import excel.SaveAccountsAndAmountsInExcel;
import gui.listModel.MyFileListModel;
import pdf.ExtractsAccountsAndAmounts;
import utilities.interfaces.CustomPair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

public class WriteToExcelButton extends JButton {

    private final String BUTTON_TEXT = "Write to excel";
    private ArrayList<CustomPair<String, BigDecimal>> accountsAndAmountsList;

    public WriteToExcelButton(){
        this.setText(BUTTON_TEXT);
        this.addActionListener(this::buttonAction);
    }

    private void buttonAction(ActionEvent event){
        String location = getLocationToSave();
        SaveAccountsAndAmountsInExcel saveAccountsAndAmountsInExcel = new SaveAccountsAndAmountsInExcel();
        accountsAndAmountsList = getAccountsAndAmountsList(MyFileListModel.getInstance().toArray());
        saveAccountsAndAmountsInExcel.saveInExcel(accountsAndAmountsList, location);
        saveAccountsAndAmountsInExcel.openExcel(location);
        MyFileListModel.setInstanceToNull();
    }

    private String getLocationToSave(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile().getAbsolutePath() + "\\";
    }

    private ArrayList<CustomPair<String, BigDecimal>> getAccountsAndAmountsList(File[] files){
        ExtractsAccountsAndAmounts extractsAccountsAndAmounts = new ExtractsAccountsAndAmounts();
        return extractsAccountsAndAmounts.getAccountsAndAmountsList(files);
    }
}
