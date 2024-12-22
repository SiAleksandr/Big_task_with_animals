package varieties.groups.pets;

import varieties.groups.Pet;
import varieties.Informer;

public class Cat extends Pet {    
    public Cat(Informer one) {
        super(one);
    }
    
    @Override
    public String getType() {
        return "Cat";
    }
}
