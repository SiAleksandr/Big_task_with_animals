import varieties.Animal;
import varieties.groups.pets.*;
import varieties.groups.packAnimals.*;
import base.util.Toolkit;
import base.Collector;
import view.View;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.buttonClick();
    }
}

        // ArrayList<Animal> allTypes = getTypes();


        // HashMap<String, String> accordance = new HashMap<>();

        // accordance.put("Cat", "Pet");
        // accordance.put("Dog", "Pet");
        // accordance.put("Hamster", "Pet");
        // accordance.put("Horse", "PackAnimal");
        // accordance.put("Camel", "PackAnimal");
        // accordance.put("Donkey", "PackAnimal");

        // cat1.setCommands("сидеть мяукать");
        // cat1.addComand("лежать");
        // horse1.setCommands("голопом стой");
        // horse1.addCommand("мелким_шагом");
        // cat1.setType("Кошка");
        // System.out.println(cat1.toString());
        // System.out.println(horse1.toString());

    // protected static ArrayList<Animal> getTypes() {
    //     ArrayList<Animal> allTypes = new ArrayList<>();
    //     allTypes.add(new Cat("Cat"));
    //     allTypes.add(new Dog("Dog"));
    //     allTypes.add(new Hamster("Hamster"));
    //     allTypes.add(new Horse("Horse"));
    //     allTypes.add(new Camel("Camel"));
    //     allTypes.add(new Donkey("Donkey"));
    //     return allTypes;
    // }
    // protected static Animal getAnimal(ArrayList<Animal> types, String dog) {
    //     int target = 0;
    //     int i = 0;
    //     while (i < types.size()) {
    //         if (types.get(i).type.equals(dog)) {
    //             target = i;
    //             i = types.size(); // Чтобы выйти из цикла
    //         }
    //         else i++;
    //     }
    //     return types.get(target);
    // }
