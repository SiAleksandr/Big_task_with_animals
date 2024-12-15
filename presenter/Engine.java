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

    public Engine(View view) {
        functional = new Propulsion();
        reveal = view;
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
                    case 2:
                        try {
                            Integer targetIndex = search(functional.collection);
                            if(targetIndex == null) {
                                throw new Exception();
                            }
                            else {
                                // !!!Начать с этого места в это воскресенье!!!
                                Animal target = functional.collection.get(targetIndex);
                                reveal.inform("Selected animal");
                                String description = target.getGroupId() + " " +
                                    target.getId() + target.getType() + " " + 
                                    target.getName() + " " + target.getOwner() + 
                                    " " + target.birthDate.toString();
                                reveal.inform(description);
                                reveal.inform("The animal knows the commands: " + 
                                target.getCommands());
                            }
                        }
                        catch (Exception e) {
                            // reveal.inform("adding a command is canceled.");
                            reveal.inform("the search is over.");
                        }
                        break;
                    // default:
                    //     break;
                }
            }

        }
        else {
            reveal.inform("There is now the end of program.");
        }
    }

    private Integer getNumOfTipe (ArrayList<Animal> animalKinds,
            String descriptionForCancel, String invitation) {
        int lastNumber = reveal.numberedTypesShow(animalKinds, descriptionForCancel);
        int minValid = 0;
        Integer choice = reveal.getValidNumber(invitation, minValid, lastNumber);
        return choice;
    }

    public Animal describeNewAnimal() throws Exception {
        ArrayList <Animal> allTypes = constructTypes();
        String descriptionForCancel = "Cancel the addition";
        String invitation = "Enter the number of type -> ";
        Integer choice = getNumOfTipe(allTypes, descriptionForCancel, invitation);
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
        // reveal.inform("");
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

    private Integer search (ArrayList<Animal> allAnimals) throws Exception {
        ArrayList<Animal> allTypes = constructTypes();  
        String  descriptionForCancel = "Cancel the search";
        String invitation = "Enter a number to search such type -> ";
        Integer choice = getNumOfTipe(allTypes, descriptionForCancel, invitation);
        if (choice == 0) {
            throw new Exception();
        }
        String wantType = allTypes.get(choice - 1).getType();
        ArrayList<Integer> possible = new ArrayList<>();
        for(int i = 0; i < allAnimals.size(); i++) {
            if (allAnimals.get(i).getType().equals(wantType)) {
                Animal item = allAnimals.get(i);
                String output = item.getId() + " " + wantType + " " + item.getName() + 
                " " + item.getBirthDate().toString() + " " + 
                item.getOwner() + " " + item.getCommands();
                System.out.println(output);
                possible.add(i);
            }
        }
        if (possible.size() == 0) {
            reveal.inform("there is not a single animal of this type yet.\n");
            throw new Exception();
        }
        invitation = "Enter the animal's name -> ";
        String wantName = reveal.getWords(invitation);
        Integer resultIndex = null;
        int count = 0;
        Integer auxiliary = null;
        for (int n = 0; n < possible.size(); n++) {
            if (allAnimals.get(possible.get(n)).getName().equals(wantName)) {
                if (count > 0) {
                    if (count == 1) {
                        Animal previousSuitable = allAnimals.get(possible.get(auxiliary));
                        String present = previousSuitable.getId() + " " + wantType + 
                        " " + wantName + " " + previousSuitable.getBirthDate().toString() + 
                        " " + previousSuitable.getOwner() + previousSuitable.getCommands();
                        reveal.inform(present);
                    }
                    Animal suitable = allAnimals.get(possible.get(n));
                    String current = suitable.getId() + " " + wantType + 
                    " " + wantName + " " + suitable.getBirthDate().toString() + 
                    " " + suitable.getOwner() + suitable.getCommands();
                    reveal.inform(current);
                    count++;
                }
                else if (count == 0) {
                    auxiliary = possible.get(n);
                    resultIndex = possible.get(n);
                    count++;
                }
            }
        }
        if(resultIndex == null) {
            reveal.inform("there is not a single animal of this type that name.");

        }
        int clear = 1;
        if (count > clear) {
            Integer targetId;
            boolean control = false;
            invitation = "Enter the ID of the desired animal -> ";
            int minSuitable = 0;
            int maxSituable = allAnimals.size() - 1;
            while (!control) {
                targetId = reveal.getValidNumber(invitation, minSuitable, maxSituable);
                int k = 0;
                while (k < possible.size()) {
                    if (allAnimals.get(possible.get(k)).getId() == targetId) {
                        resultIndex = possible.get(k);
                        k = possible.size(); //Чтобы выйти из цикла
                        control = true;
                    }
                    else k++;
                }
                if (!control) {
                    reveal.inform("There is not a single animal of this type with");
                    reveal.inform("that name and ID. Press Enter to choice ID again,");
                    String decision = reveal.getWords("or type the letter Q to go the main menu -> ");
                    decision = decision.toUpperCase();
                    if (decision.equals("Q")) {
                        throw new Exception();
                    }
                }
            }
        }
        return resultIndex;
    }
}
// There is not a single animal of this type with that name.
    // public Animal search (ArrayList<Animal> allAnimals) {}
    // Искать по типу и имени, если что, показать id



