package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

import presenter.Engine;
import varieties.Animal;
import base.Propulsion;

public class View {

    Engine process;

    public View() {}

    public void buttonClick() {
        Engine process = new Engine(this);
        this.process = process;
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
        int lineCount = 4;
        return lineCount;
    }

    public int numberedTypesShow (String[] allTypes, String zeroNumberMessage) {
        int index = 0;
        System.out.println(" " + index + " - " + zeroNumberMessage);
        while (index < allTypes.length) {
            int numberForView = index + 1; 
            String description = " " + numberForView + " - " + allTypes[index];
            System.out.println(description);
            index ++;
        }
        return index;
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
            Integer num = Integer.parseInt(value);
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
}
/*
    public void runAll() {
        System.out.println("storage information:");
        if (engine.checkStart()) {
            while(true) {
                System.out.println("\n 0. Save everything and exit");
                System.out.println(" 1. Add new animal");
                System.out.println(" 2. View commands executed by the animal");
                System.out.println(" 3. Teach the animal new command(s)");
                System.out.println(" 4. All animals by date of birth, starting from the oldest");
            

            }
        }
        else {
            System.out.println("There is now the end of program.");
            return;
        }
    } */

