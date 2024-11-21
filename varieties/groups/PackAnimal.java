package varieties.groups;
import java.util.ArrayList;

import varieties.Animal;

public abstract class PackAnimal extends Animal {
    public int packAnimalId;
    public PackAnimal(String type) {
        super(type);
    }

    public void setGroupId(ArrayList<String> pets, int packAnimalGroupId) {
        int i = 0;
        while (i < pets.size()) {
            if (type == pets.get(i)) {
                groupId = packAnimalGroupId;
                i = pets.size(); // Чтобы завершить цикл
            }
            else i++;      
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
