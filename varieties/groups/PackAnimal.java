package varieties.groups;

import varieties.Animal;

public abstract class PackAnimal extends Animal {
    public Integer packAnimalId;
    public PackAnimal(String type) {
        super(type);
    }

    @Override
    public void setId(Integer id) {
        packAnimalId = id;
    }

    @Override
    public Integer getId() {
        return packAnimalId;
    }

    public String toString() {
        return groupId + " " + packAnimalId + " " +  super.toString();
    }
}
