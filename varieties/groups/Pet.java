package varieties.groups;

import varieties.*;


public abstract class Pet extends Animal{
    public Pet(Informer one) {
        super(one);
    }

    @Override
    public String getGroup() {
        return "Pet";
    }
}
