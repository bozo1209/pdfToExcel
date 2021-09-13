package gui;

import gui.buttons.ChooseFilesButton;
import gui.buttons.ChooseLocationButton;
import gui.buttons.WriteToExcelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class PdfToExcelPanel extends JPanel {

    private final ChooseFilesButton chooseFilesButton;
    private final ChooseLocationButton chooseLocationButton;
    private final WriteToExcelButton writeToExcelButton;

    public PdfToExcelPanel(){
        this.setBackground(Color.DARK_GRAY);

        chooseFilesButton = new ChooseFilesButton();
        chooseLocationButton = new ChooseLocationButton();
        writeToExcelButton = new WriteToExcelButton(chooseFilesButton, chooseLocationButton);

        this.add(chooseFilesButton);
        this.add(chooseLocationButton);
        this.add(writeToExcelButton);
    }

}
