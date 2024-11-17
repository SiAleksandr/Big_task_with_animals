import varieties.Animal;
import varieties.groups.pets.*;
import varieties.groups.packAnimals.*;

import java.util.List;
import java.util.ArrayList;;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Horse horse1 = new Horse();
        List<Animal> list = new ArrayList<>();
        list.add(cat1);
        list.add(horse1);
        list.get(0).setCommands("сидеть мяукать");
        System.out.println(list.get(0).toString());
        list.get(1).setCommands("голопом стой");
        System.out.println(list.get(1).toString());
        // cat1.setCommands("сидеть мяукать");
        // cat1.addComand("лежать");
        // horse1.setCommands("голопом стой");
        // horse1.addCommand("мелким_шагом");
        // cat1.setType("Кошка");
        // System.out.println(cat1.toString());
        // System.out.println(horse1.toString());
    }
}