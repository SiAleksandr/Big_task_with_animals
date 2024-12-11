package presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Exception;

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

    public Propulsion functional;
    public View reveal;

    public Engine() {
        functional = new Propulsion();
        reveal = new View(this);
    }

    public ArrayList<Animal> constructTypes() {
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
                int minMenuValue = 0;
                int linesNow = reveal.showMenu();
                String invitationString = "Enter the number of action -> ";
                Integer choice = reveal.getValidNumber(invitationString, minMenuValue, linesNow);
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

    public Animal describeNewAnimal() throws Exception{
        String descriptionForCancel = "Cancel the addition";
        ArrayList<Animal> allTypes = constructTypes();
        int lastNumber = reveal.numberedTypesShow(allTypes, descriptionForCancel);
        String invitation = "Enter the number of type -> ";
        int minValue = 0;
        Integer choice = reveal.getValidNumber(invitation, minValue, lastNumber);
        if (choice == 0) {
            throw new Exception();
        }
        int index = choice - 1;
        Animal target = allTypes.get(index);
        HashMap<String, String> accordance = constructAccordance();
        target.setGroup(accordance);
        HashMap<Integer, String> groupNumbers = functional.source.groupNumbers;
        target.setGroupId(groupNumbers);
        invitation = "\nEnter the name of the animal -> ";
        String name = reveal.getWords(invitation);
        target.setName(name);
        invitation = "\nEnter the owner of this animal -> ";
        name = reveal.getWords(invitation);
        target.setOwner(name);
        reveal.inform("");
        LocalDate birthDate = enterValidDate();
        target.setBirthDate(birthDate);
        Integer newId = functional.source.setIdForNew(functional.collection, target);
        target.setId(newId);
        int currentSeat = functional.source.bigList.size();
        target.setSeat(currentSeat);
        functional.source.bigList.add(target.toString());
        return target;
    }

    private LocalDate enterValidDate () throws Exception {
        while(true) {
            int minValue = 1;
            int maxValue = 9999;
            String current = "Enter the year of birth of this animal -> ";
            Integer year = reveal.getValidNumber (current, minValue, maxValue);
            maxValue = 12;
            current = "Enter the month of birth as a number -> ";
            Integer month = reveal.getValidNumber(current, minValue, maxValue);
            maxValue = 31;
            current = "Enter the day of the month -> ";
            Integer dayOfMonth = reveal.getValidNumber(current, minValue, maxValue);
            if (functional.source.toolkit.isDate(year, month, dayOfMonth)) {
                LocalDate today = LocalDate.now();
                LocalDate birthDate = LocalDate.of(year, month, dayOfMonth);
                if ((birthDate.isBefore(today)) || (birthDate.isEqual(today))) {
                    return birthDate;
                }
            }
            reveal.inform("This date of birth are not real. Press Enter to add a valid date,");
            String input = reveal.prompt("or type the letter Q to go the main menu -> ");
            input = input.toUpperCase();
            if (input.equals("Q")) {
                throw new Exception();
            }
        }   
    }

    // public Animal search (ArrayList<Animal> allAnimals) {}
    // Искать по типу и имени, если что, показать id

}


