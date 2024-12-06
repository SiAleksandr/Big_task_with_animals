package base;

import java.util.ArrayList;

import varieties.Animal;

public class Propulsion {

    public Collector source;
    public ArrayList<Animal> animalList;

    public Propulsion() {
        source = new Collector();
    }

    public boolean start() {
        if (source.startWork()) {
            return true;
        }
        else return false;
    }
}
