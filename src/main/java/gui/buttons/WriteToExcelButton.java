package gui.buttons;

import excel.SaveAccountsAndAmountsInExcel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class WriteToExcelButton extends JButton {

    private final String BUTTON_TEXT = "Write to excel";
    private ChooseFilesButton chooseFilesButton;
//    private ChooseLocationButton chooseLocationButton;

    public WriteToExcelButton(ChooseFilesButton chooseFilesButton
//            , ChooseLocationButton chooseLocationButton
    ){
        this.chooseFilesButton = chooseFilesButton;
//        this.chooseLocationButton = chooseLocationButton;
        this.setText(BUTTON_TEXT);
        this.addActionListener(this::buttonAction);
    }

    private void buttonAction(ActionEvent event){
        String location = getLocationToSave();
        SaveAccountsAndAmountsInExcel saveAccountsAndAmountsInExcel = new SaveAccountsAndAmountsInExcel();
        saveAccountsAndAmountsInExcel.saveInExcel(chooseFilesButton.getAccountsAndAmountsList(), location);
        saveAccountsAndAmountsInExcel.openExcel(location);
    }

    private String getLocationToSave(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(null);
//        System.out.println(fileChooser.getCurrentDirectory());
        System.out.println(fileChooser.getSelectedFile());
        return fileChooser.getSelectedFile().getAbsolutePath() + "\\";
    }
}
