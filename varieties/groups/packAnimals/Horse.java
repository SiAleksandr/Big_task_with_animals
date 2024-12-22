package varieties.groups.packAnimals;

import varieties.groups.PackAnimal;
import varieties.Informer;

public class Horse extends PackAnimal {
    public Horse(Informer one) {
        super(one);
    }
    
    @Override
    public String getType() {
        return "Horse";
    }
}