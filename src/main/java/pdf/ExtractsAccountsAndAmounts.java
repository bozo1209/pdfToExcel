package pdf;

import bankNames.BankNames;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import utilities.implementations.CustomPairImp;
import utilities.implementations.ExtractingAccountAmountPairPekaoImp;
import utilities.interfaces.CustomPair;
import utilities.interfaces.ExtractingAccountAmountPair;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtractsAccountsAndAmounts<Account, Amount> {


    public ArrayList<CustomPair<Account, Amount>> getAccountsAndAmountsList(File[] files){
        ArrayList<CustomPair<Account, Amount>> accountsAndAmountsList = new ArrayList<>();
        for (File file : files){
            accountsAndAmountsList.add(checkBankName(file));
        }
        return accountsAndAmountsList;
    }

    public void printAccountsAndAmounts(ArrayList<CustomPair<Account, Amount>> list){
        System.out.println("*****************");
        list.forEach(System.out::println);
//        System.out.println(list.isEmpty());
//        System.out.println(list.get(0));
    }

    private CustomPair<Account, Amount> checkBankName(File file){
        CustomPair<Account, Amount> pair = null;
        try(PDDocument document = PDDocument.load(file)) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String text = pdfTextStripper.getText(document);
            String[] lines = text.split("\n");
            System.out.println("BankNames.PEKAO.name() " + BankNames.PEKAO.name());
            System.out.println("BankNames.PEKAO " + BankNames.PEKAO);
            for (String line : lines){
                String s = line.toUpperCase();
//                Matcher pekaoMatcher = Pattern.compile("\\.* " + "Pekao" + " \\.*\\s*").matcher(line);
//                Matcher pekaoMatcher = Pattern.compile("Bank Pekao S.A.\\s*").matcher(line);
                Matcher pekaoMatcher = Pattern.compile("[a-zA-Z]* " + BankNames.PEKAO.name() + " S.A.\\s*").matcher(s);
                System.out.println(line);
                System.out.println(line.toUpperCase());
                System.out.println("pekaoMatcher " + pekaoMatcher.matches());
                if (pekaoMatcher.matches()){
                    ExtractingAccountAmountPair<Account, Amount> extracting = new ExtractingAccountAmountPairPekaoImp<>();
                    pair = extracting.getCustomPair(lines);
                    break;
                }
            }
            System.out.println(lines);
        }catch (IOException e){
            e.printStackTrace();
        }
        return pair;
    }

}
