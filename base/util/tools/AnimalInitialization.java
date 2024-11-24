package base.util.tools;

import java.util.ArrayList;
import java.util.HashMap;

import varieties.Animal;

public class AnimalInitialization {

    public ArrayList<Animal> allTypes;
    public HashMap<String, String> groupAccordance;
    public HashMap<String, Integer> groupsNumbers;

    public AnimalInitialization (ArrayList<Animal> allTypes,
        HashMap<String, String> groupAccordance, 
        HashMap<String, Integer> groupsNumbers) {
        this.allTypes = allTypes;
        this.groupAccordance = groupAccordance;
        this.groupsNumbers = groupsNumbers;
    }

    public Animal getAnimal(ArrayList<Animal> types, String someType) {
        int target = 0;
        int i = 0;
        while (i < types.size()) {
            if (types.get(i).type.equals(someType)) {
                target = i;
                i = types.size(); // Чтобы выйти из цикла
            }
            else i++;
        }
        return types.get(target);
    }
}
