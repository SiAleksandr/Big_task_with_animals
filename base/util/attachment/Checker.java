package base.util.attachment;

import java.util.HashMap;

public interface Checker {

    public boolean isDigit (String subject);

    public boolean isDate (int year, int month, int dayOfMonth);

    public boolean lineCheck (String line,
            HashMap<String, String> groupAccordance,
            HashMap<Integer, String> groupsNumbers);


}
