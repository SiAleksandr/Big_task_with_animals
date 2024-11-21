import varieties.Animal;
import varieties.groups.pets.*;
import varieties.groups.packAnimals.*;

import java.util.List;
import java.util.ArrayList;;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> allTypes = getTypes();
        String cat = "cat";
        Animal animal = getAnimal(allTypes, cat);
        animal.setCommands("Прыгать сидеть");
        System.out.println(animal.toString());

        // cat1.setCommands("сидеть мяукать");
        // cat1.addComand("лежать");
        // horse1.setCommands("голопом стой");
        // horse1.addCommand("мелким_шагом");
        // cat1.setType("Кошка");
        // System.out.println(cat1.toString());
        // System.out.println(horse1.toString());
    }

    protected static ArrayList<Animal> getTypes() {
        ArrayList<Animal> allTypes = new ArrayList<>();
        allTypes.add(new Hamster("dog"));
        allTypes.add(new Dog("hamster"));
        allTypes.add(new Cat("cat"));
        return allTypes;
    }
    protected static Animal getAnimal(ArrayList<Animal> types, String dog) {
        int target = 0;
        int i = 0;
        while (i < types.size()) {
            if (types.get(i).type.equals(dog)) {
                target = i;
                i = types.size(); // Чтобы выйти из цикла
            }
            else i++;
        }
        return types.get(target);
    }
}