import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import pdf.ExtractsAccountsAndAmounts;
import utilities.interfaces.CustomPair;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("ddddddddddddd");

        ExtractsAccountsAndAmounts<String, BigDecimal> extractsAccountsAndAmounts = new ExtractsAccountsAndAmounts<>();
        File[] files = new File[3];
        files[0] = new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test.pdf");
        files[1] = new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test2.pdf");
        files[2] = new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test3.pdf");
        ArrayList<CustomPair<String, BigDecimal>> accountsAndAmountsList = extractsAccountsAndAmounts.getAccountsAndAmountsList(files);
        extractsAccountsAndAmounts.printAccountsAndAmounts(accountsAndAmountsList);

//        try(PDDocument document = PDDocument.load(new File("C:\\Users\\mateu\\Desktop\\Nowy folder\\pdf to excel\\pdf\\test.pdf"))) {
//            PDFTextStripper pdfTextStripper = new PDFTextStripper();
//            pdfTextStripper.setEndPage(1);
//            String text = pdfTextStripper.getText(document);
//            String[] lines = text.split("\n");
//            ArrayList<String> twoLines = new ArrayList<>();
//            for (String line : lines){
////                System.out.println(line);
//                String account = "account";
//                String amount = "amount";
//                String accountRegex = "BIEŻĄCY-PODMIOTY GOSP (?<" + account + ">\\d{2}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4})\\s[A-Z]{3}\\s*";
//                String valueRegex = "SALDO KOŃCOWE (?<" + amount + ">-?\\d{0,3}\\.?\\d{0,3}\\.?\\d{0,3}\\.?\\d{0,3},\\d{2})\\s*";
////                String valueRegex = "SALDO KOŃCOWE -?\\d*\\.694,05\\s*";
////                boolean matches1 = line.matches("BIEŻĄCY-PODMIOTY GOSP \\d{2}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s[A-Z]{3}\\s*|RACHUNKI DEPOZYTOWE\\s*");
//                boolean matches1 = line.matches(accountRegex + "|" + valueRegex);
////                Pattern pattern = Pattern.compile("");
//                Matcher matcher = Pattern.compile(accountRegex + "|" + valueRegex).matcher(line);
//                if (matcher.matches()){
//                    System.out.println(matcher.groupCount());
//                    System.out.println(matcher.group(1));
//                    System.out.println(matcher.group(2));
////                    twoLines.add(line);
//                    if (matcher.group(account) != null){
//                        twoLines.add(matcher.group(account));
//                    }else if (matcher.group(amount) != null){
//                        String amount1 = matcher.group(amount).replace(".","").replace(",", ".");
//                        BigDecimal amount2 = new BigDecimal(amount1);
//                        System.out.println(amount2);
//                        twoLines.add(amount1);
//                    }
//                }
////                boolean matches1 = line.matches("BIEŻĄCY-PODMIOTY GOSP 60 1240 1040 1111 0010 8331 4138 PLN\n");
////                boolean matches1 = line.matches("RACHUNKI DEPOZYTOWE\\s*");
////                boolean matches1 = line.matches("\\w*\\s*\\w*\\s*");
////                System.out.println(matches1);
////                if (matches1){
////                    twoLines.add(line);
//////                    System.out.println("*********************");
////                }
//            }
//            String test = "test t";
//            boolean testMat = test.matches("test t");
//            System.out.println(testMat);
//            System.out.println(text);
////            String accountLine = twoLines.get(0);
////            String valueLine = twoLines.get(1);
////            System.out.println(accountLine);
////            System.out.println(valueLine);
//        }catch (IOException e){
//            e.printStackTrace();
//            System.out.println(e);
//        }
    }
}
