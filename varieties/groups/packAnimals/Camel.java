package varieties.groups.packAnimals;

import varieties.groups.PackAnimal;
import varieties.Informer;

public class Camel extends PackAnimal {
    public Camel(Informer one) {
        super(one);
    }
    
    @Override
    public String getType() {
        return "Camel";
    }
}
