package gui;

import javax.swing.*;
import java.math.BigDecimal;

public class PdfToExcelFrame extends JFrame {

    private final String APP_TITLE = "Extracting Accounts and amounts from pdf to excel";
    private PdfToExcelPanel pdfToExcelPanel;

    public PdfToExcelFrame(){
        this.setTitle(APP_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        pdfToExcelPanel = new PdfToExcelPanel();

        this.add(pdfToExcelPanel);

        this.setVisible(true);
    }
}
