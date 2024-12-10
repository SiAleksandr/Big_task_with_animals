package view;

import java.util.Scanner;

import presenter.Engine;
import base.Propulsion;

public class View {

    public Engine process;

    public View(Engine process) {
        this.process = new Engine();
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

    public Integer getValidNumber (String invitation, int min, int max) {
        String input = prompt(invitation);
        if (process.functional.source.toolkit.isDigit(input)) {
            Integer target = Integer.parseInt(input);
            if ((target >= min) && (target <= max)) {
                return target;
            }
        }
        invitation = "Not valid input. Enter valid number -> ";
        return getValidNumber(invitation, min, max);
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

