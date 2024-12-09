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
            functional.source.getReady(accordance, allTypes);
            ArrayList<Animal> main = functional.source.rebornAll(accordance, allTypes);
            functional.setAnimalList(main);
            while(true) {
                int linesNow = reveal.showMenu();
                String invitationString = "Enter the number of action -> ";
                Integer choice = getValidNumber(invitationString, linesNow);
                switch (choice) {
                    case 0:
                        return;
                    case 1:
                        try {
                            Animal target = describeNewAnimal();
                            functional.addAnimal(target);
                        } catch (Exception e) {
                            reveal.inform("adding a new animal is canceled");
                        }
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

    private Animal describeNewAnimal() throws Exception {
        ArrayList<Animal> allTypes = constructTypes();
        String description;
        Integer index = 0;
        while (index < allTypes.size()) {
            Integer numberForView = index + 1; 
            description = " " + numberForView + " - " + allTypes.get(index).getType();
            System.out.println(description);
            index ++;
        }
        String invitation = "Enter the number of type -> ";
        int lineCount = allTypes.size();
        Integer choice = getValidNumber(invitation, lineCount);
        index = choice - 1;
        Animal target = allTypes.get(index);
        HashMap<String, String> accordance = constructAccordance();
        target.setGroup(accordance);
        HashMap<Integer, String> groupNumbers = functional.source.groupNumbers;
        target.setGroupId(groupNumbers);
        invitation = "\nEnter the name of the animal -> ";
        String name = getWords(invitation);
        target.setName(name);
        invitation = "\nEnter the owner of this animal -> ";
        name = getWords(invitation);
        target.setOwner(name);

        // Заглушка:
        return allTypes.get(5);
    }

    private Integer getValidNumber (String invitation, int max) {
        String input = reveal.prompt(invitation);
        if (functional.source.toolkit.isDigit(input)) {
            Integer target = Integer.parseInt(input);
            if ((target >= 0) && (target < max)) {
                return target;
            }
        }
        invitation = "Not valid input. Enter valid number -> ";
        return getValidNumber(invitation, max);
    }

    private String getWords(String invitation) {
        String input = reveal.prompt(invitation);
        input = input.trim();
        if (!input.isEmpty()) {
            return input;
        }
        invitation = "Not valid input. Enter the required -> ";
        return getWords(invitation);
    }

    // public boolean checkStart () {
    //     if (functional.start()) {
    //         return true;
    //     }
    //     else return false;
    // }
    // storage information
}
