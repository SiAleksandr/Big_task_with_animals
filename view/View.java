package view;

import java.util.List;
import java.util.Scanner;

import presenter.Engine;

public class View {

    Engine process;

    public View() {}

    public void buttonClick() {
        process = new Engine(this);
        process.run();
    }

    public void inform (String message) {
        System.out.println(message);
    }

    public String prompt (String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }

    public int showMenu () {
        System.out.println("\n 0. Save everything and exit");
        System.out.println(" 1. Add new animal");
        System.out.println(" 2. View commands executed by the animal");
        System.out.println(" 3. Teach the animal new command(s)");
        System.out.println(" 4. All animals by date of birth, starting from the oldest");
        System.out.println(" 5. The total number of animals");
        int lastNumber = 5;
        return lastNumber;
    }

    public int numberedTypesShow (String[] allTypes, String zeroNumberMessage) {
        int index = 0;
        System.out.println("\n " + index + " - " + zeroNumberMessage);
        while (index < allTypes.length) {
            int numberForView = index + 1; 
            String description = " " + numberForView + " - " + allTypes[index];
            System.out.println(description);
            index ++;
        }
        return index;
    }

    public String findTheType(String[] numberedTypes, String descriptionForCancel,
                                String invitation) throws Exception {
        int lastOption = numberedTypesShow(numberedTypes, descriptionForCancel);
        int minValue = 0;
        Integer typeNumber = getValidNumber(invitation, minValue, lastOption);
        if(typeNumber == 0) {
            inform("");
            throw new Exception();
        }
        return numberedTypes[typeNumber - 1];
    }

    public Integer getValidNumber (String invitation, int min, int max) {
        String input = prompt(invitation);
        if (isDigit(input)) {
            Integer target = Integer.parseInt(input);
            if ((target >= min) && (target <= max)) {
                return target;
            }
        }
        invitation = "Not valid input. Enter valid number -> ";
        return getValidNumber(invitation, min, max);
    }

    private boolean isDigit (String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getWords(String invitation) {
        String input = prompt(invitation);
        input = input.trim();
        if (!input.isEmpty()) {
            return input;
        }
        invitation = "Not valid input. Enter the required -> ";
        return getWords(invitation);
    }

    public void printList(List<String> target) {
        for(int i = 0; i < target.size(); i++) {
            String line = target.get(i).replace('|', ' ');
            System.out.println(line);
        }
    }
}


