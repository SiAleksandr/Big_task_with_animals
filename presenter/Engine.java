package presenter;

import java.util.ArrayList;
import java.util.HashMap;

import base.Propulsion;
import view.View;
import varieties.Animal;
import varieties.groups.packAnimals.Camel;
import varieties.groups.packAnimals.Donkey;
import varieties.groups.packAnimals.Horse;
import varieties.groups.pets.Cat;
import varieties.groups.pets.Dog;
import varieties.groups.pets.Hamster;

public class Engine {

    Propulsion functional;
    View reveal;

    public Engine() {
        functional = new Propulsion();
        reveal = new View();
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

    public void run () {
        reveal.inform("storage information:");
        if (functional.start()) {
            HashMap<String, String> accordance = constructAccordance();
            ArrayList<Animal> allTypes = constructTypes();
            functional.source.rebornAll(accordance, allTypes);
            while(true) {
                int linesNow = reveal.showMenu();
                String invitationString = "Enter the number of action -> ";
                Integer choice = getValidNumber(invitationString, linesNow);
                switch (choice) {
                    case 0:
                        return;
                    case 1:
                        break;
                    default:
                        break;
                }
            }

        }
        else {
            reveal.inform("There is now the end of program.");
        }
    }

//    Not valid input. Enter valid number -> 
    private Integer getValidNumber (String invitation, int max) {
        String input = reveal.prompt(invitation);
        if (functional.source.toolkit.isDigit(input)) {
            Integer target = Integer.parseInt(input);
            if ((target >= 0) && (target <= max)) {
                return target;
            }
        }
        invitation = "Not valid input. Enter valid number -> ";
        return getValidNumber(invitation, max);
    }

    // public boolean checkStart () {
    //     if (functional.start()) {
    //         return true;
    //     }
    //     else return false;
    // }
    // storage information
}
