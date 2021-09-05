package utilities.interfaces;

import java.io.File;

public interface ExtractingAccountAmountPair<Account,Amount> {

    public CustomPair<Account, Amount> getCustomPair(String[] lines);
}
