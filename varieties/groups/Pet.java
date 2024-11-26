package varieties.groups;

import varieties.Animal;

public abstract class Pet extends Animal{
    public Integer petId;

    public Pet(String type) {
        super(type);
    }

    @Override
    public void setId(Integer id) {
        petId = id;
    }

    public String toString() {
        return groupId + " " + petId + " " + super.toString();
    }
}
