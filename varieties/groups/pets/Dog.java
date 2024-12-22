package varieties.groups.pets;

import varieties.groups.Pet;
import varieties.Informer;

public class Dog extends Pet {
    public Dog(Informer one) {
        super(one);
    }
    
    @Override
    public String getType() {
        return "Dog";
    }
}
