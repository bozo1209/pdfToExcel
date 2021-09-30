package gui.panels;

import gui.buttons.ChooseFilesButton;
import gui.buttons.WriteToExcelButton;

import javax.swing.*;
import java.awt.*;

public class PdfToExcelPanel extends JPanel {

    public PdfToExcelPanel(){
        this.setBackground(Color.DARK_GRAY);
        this.add(new ChooseFilesButton());
        this.add(new WriteToExcelButton());
    }

}
