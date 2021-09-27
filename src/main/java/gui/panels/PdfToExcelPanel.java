package gui.panels;

import gui.buttons.ChooseFilesButton;
import gui.buttons.WriteToExcelButton;

import javax.swing.*;
import java.awt.*;

public class PdfToExcelPanel extends JPanel {

    private final ChooseFilesButton chooseFilesButton;
    private final WriteToExcelButton writeToExcelButton;

    public PdfToExcelPanel(){
        this.setBackground(Color.DARK_GRAY);

        chooseFilesButton = new ChooseFilesButton();
        writeToExcelButton = new WriteToExcelButton();

        this.add(chooseFilesButton);
        this.add(writeToExcelButton);
    }

}
