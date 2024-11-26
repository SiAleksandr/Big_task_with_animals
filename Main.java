import varieties.Animal;
import varieties.groups.pets.*;
import varieties.groups.packAnimals.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> allTypes = getTypes();
        String cat = "Cat";
        Animal animal = getAnimal(allTypes, cat);


        HashMap<String, String> accordance = new HashMap<>();
        accordance.put("Cat", "Pet");
        accordance.put("Dog", "Pet");
        accordance.put("Hamster", "pet");
        accordance.put("Horse", "PackAnimal");
        accordance.put("Camel", "PackAnimal");
        accordance.put("Donkey", "PackAnimal");

        HashMap<String, Integer> groups = new HashMap<>();
        groups.put("Pet", 0);
        groups.put("PackAnimals", 1);

        animal.setGroup(accordance);
        animal.setGroupId(groups);
        animal.setId(4);
        animal.setName("Pussy");
        animal.setOwner("Sikalov Aleksandr");
        LocalDate d = LocalDate.of(2025,  11, 30);
        animal.setBirthDate(d);
        animal.setCommands("Прыгать сидеть");
        System.out.println(animal.toString());
        
        // Как пройти список st с конца и до null
        // ArrayList<String> st = new ArrayList<>();
        // st.add("jjhf");
        // st.add(null);
        // st.add("nndf");
        // int i = st.size() - 1;
        // while(i >= 0) {
        //     if(!(st.get(i) == null)) {
        //         System.out.println(st.get(i));
        //         i --;
        //     }
        //     else i = -1;   
        // }

        // Так можно
        // System.out.println(st.get(0) + null + "jj");


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
        allTypes.add(new Hamster("Dog"));
        allTypes.add(new Dog("Hamster"));
        allTypes.add(new Cat("Cat"));
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