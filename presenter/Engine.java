package presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import base.Service;
import base.util.Collector;

import java.util.HashMap;
import java.lang.Exception;

import view.View;
import varieties.Animal;
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
                    return;
                }
                case 1: {
                    // try {
                    //     Animal target = describeNewAnimal();
                    //     functional.addAnimal(target);
                    // } catch (Exception e) {
                    //     reveal.inform("adding a new animal is canceled");
                    // }
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
                                while(!answer.isEmpty() && 
                                    (!answer.equals("R") || !answer.equals("r"))) {
                                        answer = offer.prompt(
                                            "Press ENTER to save or enter R to reassign -> ");
                                    }
                                }
                                updatedCommands = updatedCommands.replace(' ', '|');
                                pupil.setCommands(updatedCommands);
                        } catch(Exception e) {
                            offer.inform("adding a commands is canceled.");
                        }
                    }
                    default:

                        break;
            }     
        }
    }
    // private Integer getNumOfTipe (ArrayList<Animal> animalKinds,
    //         String descriptionForCancel, String invitation) {
    //     int lastNumber = reveal.numberedTypesShow(animalKinds, descriptionForCancel);
    //     int minValid = 0;
    //     Integer choice = reveal.getValidNumber(invitation, minValid, lastNumber);
    //     return choice;
    // }

    // private LocalDate enterValidDate () throws Exception {
    //     while(true) {
    //         int minValue = 1;
    //         int maxValue = 9999;
    //         String current = "Enter the year of birth of this animal -> ";
    //         Integer year = reveal.getValidNumber (current, minValue, maxValue);
    //         maxValue = 12;
    //         current = "Enter the month of birth as a number -> ";
    //         Integer month = reveal.getValidNumber(current, minValue, maxValue);
    //         maxValue = 31;
    //         current = "Enter the day of the month -> ";
    //         Integer dayOfMonth = reveal.getValidNumber(current, minValue, maxValue);
    //         if (functional.source.toolkit.isDate(year, month, dayOfMonth)) {
    //             LocalDate today = LocalDate.now();
    //             LocalDate birthDate = LocalDate.of(year, month, dayOfMonth);
    //             if ((birthDate.isBefore(today)) || (birthDate.isEqual(today))) {
    //                 return birthDate;
    //             }
    //         }
    //         reveal.inform("This date of birth are not real. Press Enter to add a valid date,");
    //         String input = reveal.prompt("or type the letter Q to go the main menu -> ");
    //         input = input.toUpperCase();
    //         if (input.equals("Q")) {
    //             throw new Exception();
    //         }
    //     }
    // }

    private Animal search() throws Exception {
        String  descriptionForCancel = "Cancel the search";
        int lastOption = offer.numberedTypesShow(numberedTypes, 
                                            descriptionForCancel);
        int minValue = 0;
        String invitation = "Enter a number to search such type -> ";
        Integer typeNumber = offer.getValidNumber(invitation, minValue, lastOption);
        String typeTarget = numberedTypes[typeNumber - 1];
        List<String> sameType = serve.sameTypeSearch(typeTarget);
        if(sameType.size() == 0) {
            offer.inform("===========================================");
            offer.inform("there is not a single animal of this type yet.");
            throw new Exception();
        }
        if(sameType.size() == 1) {
            offer.inform("=======================================");
            offer.inform("Only one animal.");
            return serve.transform.reborn(sameType.get(0));
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
            return serve.transform.reborn(result.get(0));
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
        return serve.transform.reborn(targetLine);
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



