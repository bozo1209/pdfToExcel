import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("ddddddddddddd");

        try(PDDocument document = PDDocument.load(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test.pdf"))) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            pdfTextStripper.setEndPage(1);
            String text = pdfTextStripper.getText(document);
            System.out.println(text);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
