package view;

import java.util.Scanner;

import presenter.Engine;

public class View {

    public View() {}

    public void inform (String message) {
        System.out.println(message);
    }

    public void showMenu () {
        System.out.println("\n 0. Save everything and exit");
        System.out.println(" 1. Add new animal");
        System.out.println(" 2. View commands executed by the animal");
        System.out.println(" 3. Teach the animal new command(s)");
        System.out.println(" 4. All animals by date of birth, starting from the oldest");        
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

    public String prompt (String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }
}

