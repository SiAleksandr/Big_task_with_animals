package base.util.attachment;

import java.util.ArrayList;

import varieties.Animal;

public abstract class Triviality {

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

    public ArrayList<String> getStringList(ArrayList<Animal> animals) {
        ArrayList<String> simpleEntries = new ArrayList<>();
        for(Animal one: animals) {
            simpleEntries.add(one.toString());
        }
        return simpleEntries;
    }
}
    

// boolean lineCheck (String line, ArrayList<Animal> allTypes,
// HashMap<String, String> groupAccordance,
// HashMap<String, Integer> groupsNumbers);