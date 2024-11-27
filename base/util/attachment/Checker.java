package base.util.attachment;

import java.util.ArrayList;
import java.util.HashMap;

import varieties.Animal;

public interface Checker {

    public boolean lineCheck (String line, ArrayList<Animal> allTypes,
            HashMap<String, String> groupAccordance,
            HashMap<String, Integer> groupsNumbers);

}
