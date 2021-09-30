package gui;

import gui.panels.PdfToExcelPanel;
import gui.panels.PdfsListPanel;

import javax.swing.*;
import java.awt.*;

public class PdfToExcelFrame extends JFrame {

    public PdfToExcelFrame(){
        String APP_TITLE = "Extracting Accounts and amounts from pdf to excel";
        this.setTitle(APP_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 500);
        this.setLayout(new BorderLayout());
        this.add(new PdfToExcelPanel(), BorderLayout.NORTH);
        this.add(new PdfsListPanel(), BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
