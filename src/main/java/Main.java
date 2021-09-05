import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("ddddddddddddd");

        try(PDDocument document = PDDocument.load(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test.pdf"))) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            pdfTextStripper.setEndPage(1);
            String text = pdfTextStripper.getText(document);
            String[] lines = text.split("\n");
            ArrayList<String> twoLines = new ArrayList<>();
            for (String line : lines){
//                System.out.println(line);
                String accountRegex = "BIEŻĄCY-PODMIOTY GOSP \\d{2}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s[A-Z]{3}\\s*";
                String valueRegex = "SALDO KOŃCOWE -?\\d{0,3}\\.?\\d{0,3}\\.?\\d{0,3}\\.?\\d{0,3},\\d{2}\\s*";
//                String valueRegex = "SALDO KOŃCOWE -?\\d*\\.694,05\\s*";
//                boolean matches1 = line.matches("BIEŻĄCY-PODMIOTY GOSP \\d{2}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s[A-Z]{3}\\s*|RACHUNKI DEPOZYTOWE\\s*");
                boolean matches1 = line.matches(accountRegex + "|" + valueRegex);
//                boolean matches1 = line.matches("BIEŻĄCY-PODMIOTY GOSP 60 1240 1040 1111 0010 8331 4138 PLN\n");
//                boolean matches1 = line.matches("RACHUNKI DEPOZYTOWE\\s*");
//                boolean matches1 = line.matches("\\w*\\s*\\w*\\s*");
//                System.out.println(matches1);
                if (matches1){
                    twoLines.add(line);
//                    System.out.println("*********************");
                }
            }
            String test = "test t";
            boolean testMat = test.matches("test t");
            System.out.println(testMat);
//            System.out.println(text);
            String accountLine = twoLines.get(0);
            String valueLine = twoLines.get(1);
            System.out.println(accountLine);
            System.out.println(valueLine);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
