package presenter;

import java.util.ArrayList;
import java.util.HashMap;

import base.Propulsion;
import varieties.Animal;
import varieties.groups.packAnimals.Camel;
import varieties.groups.packAnimals.Donkey;
import varieties.groups.packAnimals.Horse;
import varieties.groups.pets.Cat;
import varieties.groups.pets.Dog;
import varieties.groups.pets.Hamster;

public class Engine {

    Propulsion functional;

    public Engine() {
        functional = new Propulsion();
    }

    private ArrayList<Animal> constructTypes() {
        ArrayList<Animal> allTypes = new ArrayList<>();
        allTypes.add(new Cat("Cat"));
        allTypes.add(new Dog("Dog"));
        allTypes.add(new Hamster("Hamster"));
        allTypes.add(new Horse("Horse"));
        allTypes.add(new Camel("Camel"));
        allTypes.add(new Donkey("Donkey"));
        return allTypes;
    }

    private HashMap<String, String> constructAccordance() {
        HashMap<String, String> accordance = new HashMap<>();
        accordance.put("Cat", "Pet");
        accordance.put("Dog", "Pet");
        accordance.put("Hamster", "Pet");
        accordance.put("Horse", "PackAnimal");
        accordance.put("Camel", "PackAnimal");
        accordance.put("Donkey", "PackAnimal");
        return accordance;
    }

    public boolean checkStart () {
        if (functional.start()) {
            return true;
        }
        else return false;
    }
    // storage information
}