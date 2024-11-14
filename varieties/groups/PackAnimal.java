package varieties.groups;
import varieties.Animal;

public abstract class PackAnimal extends Animal {
    public int packAnimalId;
    public PackAnimal() {
        super();
        super.groupId = 1;
    }
}
