package varieties.groups;

import varieties.*;

public abstract class PackAnimal extends Animal {

    public PackAnimal(Informer one) {
        super(one);
    }

    @Override
    public String getGroup() {
        return "PackAnimal";
    }
}
