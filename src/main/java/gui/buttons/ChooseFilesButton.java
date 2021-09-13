package gui.buttons;

import pdf.ExtractsAccountsAndAmounts;
import utilities.interfaces.CustomPair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ChooseFilesButton extends JButton {

    private final String BUTTON_TEXT = "Choose files";
    private ArrayList<CustomPair<String, BigDecimal>> accountsAndAmountsList;

    public ChooseFilesButton(){
        this.setText(BUTTON_TEXT);
        this.addActionListener(this::buttonAction);
    }

    private void buttonAction(ActionEvent event){
        System.out.println("tesssssssssssssst");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setCurrentDirectory(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf"));
//        int response = fileChooser.showSaveDialog(null);
        int response2 = fileChooser.showOpenDialog(null);
        File[] files = fileChooser.getSelectedFiles();
        ExtractsAccountsAndAmounts<String, BigDecimal> extractsAccountsAndAmounts = new ExtractsAccountsAndAmounts<>();
//        File[] files = new File[1];
//        files[0] = file;
        accountsAndAmountsList = extractsAccountsAndAmounts.getAccountsAndAmountsList(files);
        extractsAccountsAndAmounts.printAccountsAndAmounts(accountsAndAmountsList);
    }

    public ArrayList<CustomPair<String, BigDecimal>> getAccountsAndAmountsList() {
        return accountsAndAmountsList;
    }
}
