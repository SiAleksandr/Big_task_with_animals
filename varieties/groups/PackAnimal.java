package varieties.groups;
import varieties.Animal;

public abstract class PackAnimal extends Animal {
    public int packAnimalId;
    public PackAnimal(String type) {
        super(type);
        super.groupId = 1;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
