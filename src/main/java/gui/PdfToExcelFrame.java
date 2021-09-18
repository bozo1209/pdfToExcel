package gui;

import gui.panel.PdfToExcelPanel;
import gui.panel.PdfsListPanel;

import javax.swing.*;
import java.awt.*;

public class PdfToExcelFrame extends JFrame {

    private final String APP_TITLE = "Extracting Accounts and amounts from pdf to excel";
    private PdfToExcelPanel pdfToExcelPanel;
    private PdfsListPanel pdfsListPanel;

    public PdfToExcelFrame(){
        this.setTitle(APP_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        pdfToExcelPanel = new PdfToExcelPanel();
        pdfsListPanel = new PdfsListPanel();

        this.add(pdfToExcelPanel, BorderLayout.NORTH);
        this.add(pdfsListPanel, BorderLayout.CENTER);

//        this.pack();
        this.setVisible(true);
    }
}
