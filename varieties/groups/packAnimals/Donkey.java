package varieties.groups.packAnimals;

import varieties.groups.PackAnimal;
import varieties.Informer;

public class Donkey extends PackAnimal {
    public Donkey(Informer one) {
        super(one);
    }
    
    @Override
    public String getType() {
        return "Donkey";
    }
}
