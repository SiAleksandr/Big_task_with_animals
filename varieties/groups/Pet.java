package varieties.groups;
import java.util.ArrayList;

import varieties.Animal;

public abstract class Pet extends Animal{
    public int petId;

    public Pet(String type) {
        super(type);
    }

    public void getGroupId(ArrayList<String> pets, int petGroupId) {
        int i = 0;
        while (i < pets.size()) {
            if (type == pets.get(i)) {
                groupId = petGroupId;
                i = pets.size(); // Чтобы завершить цикл
            }
        }
    }

    public void getPetId (int petId) {
        this.petId = petId;
    } // Придумать способ получения
    // индивидуального petId при добавлении нового животного
    @Override
    public String toString() {
        return petId + " " + super.toString();
    }
}
