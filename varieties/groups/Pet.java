package varieties.groups;

import java.time.LocalDate;

import varieties.Animal;
import varieties.Informer;

public abstract class Pet extends Animal{
    public Pet(Informer one) {
        super(one);
    }

    @Override
    public String getGroup() {
        return "Pet";
    }
}
