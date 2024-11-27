package base.util.addition;

import java.util.ArrayList;
import java.util.HashMap;

import varieties.Animal;

public interface Preparer {

    Animal getAnimal(ArrayList<Animal> types, String someType);
    
    boolean lineCheck (String line, ArrayList<Animal> allTypes,
        HashMap<String, String> groupAccordance,
        HashMap<String, Integer> groupsNumbers);
}
