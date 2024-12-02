package base.util.attachment;

import java.util.ArrayList;
import java.util.HashMap;

import varieties.Animal;

public interface Checker {

    public boolean isDigit (String subject);

    public boolean lineCheck (String line,
            HashMap<String, String> groupAccordance,
            HashMap<Integer, String> groupsNumbers);

}
