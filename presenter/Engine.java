package presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Exception;

import base.Service;
import view.View;
import varieties.Animal;
import varieties.Informer;
import varieties.groups.packAnimals.Camel;
import varieties.groups.packAnimals.Donkey;
import varieties.groups.packAnimals.Horse;
import varieties.groups.pets.Cat;
import varieties.groups.pets.Dog;
import varieties.groups.pets.Hamster;

public class Engine {
    private String[] numberedTypes;
    private Map<String, String> accordance;

    public Service serve;
    public View offer;

    public Engine(View view) {
        offer = view;
        serve = new Service();
    }

    private void constructAccordance() {
        int typesCount = 6;
        numberedTypes = new String[typesCount];
        accordance = new HashMap<>();
        accordance.put("Cat", "Pet");
        numberedTypes[0] = "Cat";
        accordance.put("Dog", "Pet");
        numberedTypes[1] = "Dog";
        accordance.put("Hamster", "Pet");
        numberedTypes[2] = "Hamster";
        accordance.put("Horse", "PackAnimal");
        numberedTypes[3] = "Horse";
        accordance.put("Camel", "PackAnimal");
        numberedTypes[4] = "Camel";
        accordance.put("Donkey", "PackAnimal");
        numberedTypes[5] = "Donkey";
    }

    private Animal defineTheType (String typeName, Informer tipster) {
        switch (typeName) {
            case "Cat":
                return new Cat(tipster);
            case "Dog":
                return new Dog(tipster);
            case "Hamster": 
                return new Hamster(tipster);
            case "Horse":
                return new Horse(tipster);
            case "Camel":
                return new Camel(tipster);
            default:
                return new Donkey(tipster);
        }
    }

    public void run () {
        offer.inform("\nstorage information:");
        if (!serve.start()) {
            offer.inform("the storage creation failed.");
            offer.inform("there is now the end of program.");
            return;
        }
        constructAccordance();
        serve.generateLists(accordance);
        if(serve.corruptedData.size() > 0) {
            offer.inform("corrupted data:");
            offer.printList(serve.corruptedData);
        }
        while(true) {
            int minMenuValue = 0;
            int linesNow = offer.showMenu();
            String invitationString = "Enter the number of action -> ";
            Integer choice = offer.getValidNumber(invitationString, minMenuValue, linesNow);
            switch (choice) {
                case 0: {
                    serve.saveWithCorruptedData();
                    return;
                    }
                case 1: {
                    try {
                        Animal target = describeNewAnimal();
                        serve.addNewAnimal(target);
                        offer.inform("=======================================");
                        offer.inform("Added an animal like this:");
                        offer.inform(target.toView());
                        offer.prompt("Press ENTER > ");
                    } catch (Exception e) {
                        offer.prompt("adding a new animal is canceled. Press ENTER > ");
                    }
                        break;
                    }
                case 2: {
                    try {
                        Animal target = search();
                        offer.inform("Here is an animal:");
                        offer.inform(target.toView());
                        String commands = target.getCommands().replace('|', ' ');
                        offer.prompt("COMMANDS (press ENTER): " + commands + " > ");
                    } catch (Exception e) {
                        offer.prompt("the search is over. Press ENTER > ");
                    }
                    break;
                    }
                case 3: {
                    try {
                        Animal pupil = search();
                        offer.inform("Here is an animal:");
                        offer.inform(pupil.toView());
                        String baseCommands = pupil.getCommands().replace('|', ' ');
                        String invitation = "Enter command(s) to teach -> ";
                        String answer = "r";
                        String updatedCommands = "";
                        while(answer.equals("r") || answer.equals("R")) {
                            updatedCommands = enterCommands(baseCommands, invitation);
                            offer.inform("Commands will: " + updatedCommands);
                            answer = "_";
                            while(!answer.isEmpty() && 
                                (!answer.equals("R") && !answer.equals("r"))) {
                                    answer = offer.prompt(
                                        "Press ENTER to save or enter R to reassign -> ");
                                }
                            }
                            updatedCommands = updatedCommands.replace(' ', '|');
                            pupil.setCommands(updatedCommands);
                            serve.saveNewCommand(pupil);
                    } catch(Exception e) {
                            offer.prompt("adding a commands is failed. Press ENTER > ");
                    }
                    break;
                    }
                case 4: {
                    offer.inform("");
                    String[] pointers = serve.organize();
                    for(int p = 0; p < pointers.length; p++) {
                        int item = Integer.valueOf(pointers[p]);
                        String current = serve.bigList.get(item);
                        Informer informer = serve.transform.prepare(current);
                        String[] data = current.split(" ");
                        Animal animal = defineTheType(data[2], informer);
                        offer.inform(animal.toView());
                    }
                    offer.prompt("Press ENTER > ");
                    break;
                    }
                case 5: {
                    offer.inform("");
                    Integer totalNumber = serve.bigList.size();
                    offer.inform("Total: " + totalNumber);
                    offer.prompt("Press ENTER > ");
                    break;
                }           
            }    
        }
    }

    private Animal describeNewAnimal() throws Exception {
        String descriptionForCancel = "Cancel";
        String invitation = "Enter the type number -> ";
        String typeTarget = offer.findTheType(numberedTypes, descriptionForCancel, invitation);
        Long newId = serve.getNewId();
        invitation = "Enter the animal`s name -> ";
        String targetName = offer.getWords(invitation);
        targetName = targetName.replace(' ', '|');
        List <String> twoGenders = new ArrayList<>();
        twoGenders.add("male");
        twoGenders.add("female");
        int maleNumber = 1;
        int femaleNumber = 2;
        offer.inform(" - " + maleNumber + " - " + twoGenders.get(maleNumber - 1));
        offer.inform(" - " + femaleNumber + " - " + twoGenders.get(femaleNumber - 1));
        invitation = "Which gender (enter it`s number) -> ";
        int genderNumber = offer.getValidNumber(invitation, maleNumber, femaleNumber);
        String targetGender = twoGenders.get(genderNumber - 1);
        LocalDate targetBirthDate = enterValidDate();
        invitation = "Animal executes commands (enter it) -> ";
        String targetCommands = offer.prompt(invitation);
        if(targetCommands.isEmpty()) {
            targetCommands = "Live";
        }
        else {
            targetCommands = targetCommands.replace(' ', '|');
        }
        Informer targetInformer = new Informer(newId, targetName, targetGender, 
                                                targetBirthDate, targetCommands);
        return defineTheType(typeTarget, targetInformer);
    }

    private LocalDate enterValidDate () throws Exception {
        while(true) {
            int minValue = 1;
            int maxValue = 9999;
            String current = "Enter the year of birth of this animal -> ";
            Integer year = offer.getValidNumber (current, minValue, maxValue);
            maxValue = 12;
            current = "Enter the month of birth as a number -> ";
            Integer month = offer.getValidNumber(current, minValue, maxValue);
            maxValue = 31;
            current = "Enter the day of the month -> ";
            Integer dayOfMonth = offer.getValidNumber(current, minValue, maxValue);
            if (serve.transform.check.IsDateElements(year, month, dayOfMonth)) {
                LocalDate today = LocalDate.now();
                LocalDate birthDate = LocalDate.of(year, month, dayOfMonth);
                if ((birthDate.isBefore(today)) || (birthDate.isEqual(today))) {
                    return birthDate;
                }
            }
            offer.inform("This date of birth are not real. Press Enter to add a valid date,");
            String input = offer.prompt("or type the letter Q to go the main menu -> ");
            input = input.toUpperCase();
            if (input.equals("Q")) {
                throw new Exception();
            }
        }
    }

    private Animal search() throws Exception {
        String  descriptionForCancel = "Cancel the search";
        String invitation = "Enter a number to search such type -> ";
        String typeTarget = offer.findTheType(numberedTypes, descriptionForCancel, invitation);
        List<String> sameType = serve.sameTypeSearch(typeTarget);
        if(sameType.size() == 0) {
            offer.inform("===========================================");
            offer.inform("there is not a single animal of this type yet.");
            throw new Exception();
        }
        Informer informer;
        if(sameType.size() == 1) {
            offer.inform("=======================================");
            offer.inform("Only one animal.");
            informer = serve.transform.prepare(sameType.get(0));
            return defineTheType(typeTarget, informer);
        }
        offer.printList(sameType);
        invitation = "Enter the animal's name -> ";
        offer.inform("");
        String elect = offer.getWords(invitation);
        List<String> result = serve.nameSearch(sameType, elect);
        if(result.size() == 0) {
            offer.inform("=============================");
            offer.inform("Not valid name.");
            throw new Exception();
        }
        if(result.size() == 1){
            offer.inform("========================================");
            informer = serve.transform.prepare(result.get(0));
            return defineTheType(typeTarget, informer);
        }
        invitation = "Enter the ID of the animal -> ";
        String input;
        String targetLine = null;
        while(targetLine == null) {
            offer.printList(result);
            input = offer.getWords(invitation);
            if (input.equals("Q") || input.equals("q")) {
                offer.inform("============================================");
                throw new Exception();
            }
            targetLine = serve.idSearch(result, input);
            if(targetLine == null) {
                offer.inform("\nWrong value.");
                invitation = "Try again or enter Q to cancel -> ";

            }
        }
        offer.inform("============================================");
        informer = serve.transform.prepare(targetLine);
        return defineTheType(typeTarget, informer);
    }

    public String enterCommands(String baseCommands, String invitation) {
        if(baseCommands.equals("Live")) {
            baseCommands = "";
        }
        String newCommands = offer.prompt(invitation);
        newCommands = newCommands.trim();
        if (baseCommands.isEmpty()) {
            if (newCommands.isEmpty()) return "Live";
            else baseCommands = newCommands;
        } else if(!newCommands.isEmpty()) {
            baseCommands += ", " + newCommands;
        }
        return baseCommands;
    }
}



