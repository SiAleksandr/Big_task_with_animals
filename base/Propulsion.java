package base;

import java.util.ArrayList;

import varieties.Animal;

public class Propulsion {

    public Collector source;
    public ArrayList<Animal> collection;

    public Propulsion() {
        source = new Collector();
    }

    public boolean start() {
        if (source.startWork()) {
            return true;
        }
        else return false;
    }

    public void setAnimalList (ArrayList<Animal> animalList) {
        this.collection = animalList;
    }

    public void addAnimal (Animal target) {        
        collection.add(target);

// придумать, как присвоить petId, например и seat для списка из Collector
    }

    public ArrayList<Animal> getCollection () {
        return collection;
    }
}
