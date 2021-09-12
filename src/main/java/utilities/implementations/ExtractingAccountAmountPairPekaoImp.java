package utilities.implementations;

import org.apache.pdfbox.pdmodel.PDDocument;
import utilities.interfaces.CustomPair;
import utilities.interfaces.ExtractingAccountAmountPair;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractingAccountAmountPairPekaoImp<Account, Amount> implements ExtractingAccountAmountPair<Account, Amount> {
    @Override
    public CustomPair<Account, Amount> getCustomPair(String[] lines){
        CustomPair<Account, Amount> pair = new CustomPairImp<>();
        String account = "account";
        String amount = "amount";
        String accountRegex = "BIEŻĄCY-PODMIOTY GOSP (?<" + account + ">\\d{2}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4})\\s[A-Z]{3}\\s*";
        String valueRegex = "SALDO KOŃCOWE (?<" + amount + ">-?\\d{0,3}\\.?\\d{0,3}\\.?\\d{0,3}\\.?\\d{0,3},\\d{2})\\s*";
        for (String line : lines){
            Matcher matcher = Pattern.compile(accountRegex + "|" + valueRegex).matcher(line);
            if (matcher.matches()){
                if (matcher.group(account) != null){
                    pair.setAccount((Account) matcher.group(account));
                }else if (matcher.group(amount) != null){
                    pair.setAmount((Amount) matcher.group(amount).replace(".", "").replace(",", "."));
                }
            }
            if (pair.getAccount() != null && pair.getAmount() != null){
                break;
            }
        }
        return pair;
    }
}
