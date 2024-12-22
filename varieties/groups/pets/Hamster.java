package varieties.groups.pets;

import varieties.groups.Pet;
import varieties.Informer;

public class Hamster extends Pet {
    public Hamster(Informer one) {
        super(one);
    }
    
    @Override
    public String getType() {
        return "Hamster";
    }
}
