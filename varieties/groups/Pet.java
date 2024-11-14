package varieties.groups;
import varieties.Animal;

public abstract class Pet extends Animal{
    public int petId;
    public Pet() {
        super();
        super.groupId = 0;
    }
}
