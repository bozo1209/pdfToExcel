package gui.buttons;

import excel.SaveAccountsAndAmountsInExcel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class WriteToExcelButton extends JButton {

    private final String BUTTON_TEXT = "Write to excel";
    private ChooseFilesButton chooseFilesButton;
    private ChooseLocationButton chooseLocationButton;

    public WriteToExcelButton(ChooseFilesButton chooseFilesButton, ChooseLocationButton chooseLocationButton){
        this.chooseFilesButton = chooseFilesButton;
        this.chooseLocationButton = chooseLocationButton;
        this.setText(BUTTON_TEXT);
        this.addActionListener(this::buttonAction);
    }

    private void buttonAction(ActionEvent event){
        SaveAccountsAndAmountsInExcel<String, BigDecimal> saveAccountsAndAmountsInExcel = new SaveAccountsAndAmountsInExcel<>();
        saveAccountsAndAmountsInExcel.saveInExcel(chooseFilesButton.getAccountsAndAmountsList(), chooseLocationButton.getLocationSavaPath());
    }
}
