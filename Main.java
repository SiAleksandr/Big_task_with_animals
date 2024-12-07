import varieties.Animal;
import varieties.groups.pets.*;
import varieties.groups.packAnimals.*;
import base.util.Toolkit;
import base.Collector;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Main {
    private static Collector col;
        static {
            col = new Collector();
        }
    public static void main(String[] args) {

        ArrayList<Animal> allTypes = getTypes();


        HashMap<String, String> accordance = new HashMap<>();

        accordance.put("Cat", "Pet");
        accordance.put("Dog", "Pet");
        accordance.put("Hamster", "Pet");
        accordance.put("Horse", "PackAnimal");
        accordance.put("Camel", "PackAnimal");
        accordance.put("Donkey", "PackAnimal");

        Collector co = new Collector();

    
            co.startWork();
            co.getReady(accordance, allTypes);
            ArrayList<Animal> a = co.rebornAll(accordance, allTypes);
            for(int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i).toString());
            }

            for (int n = 0; n < co.corruptedData.size(); n++) {
                System.out.println("Error: " + co.corruptedData.get(n));
            }
            co.saveAll();
            System.out.println("Конец");
            System.out.println("\n 0. Save everything and exit");
            System.out.println(" 1. Add new animal");
            System.out.println(" 2. View commands executed by the animal");
            System.out.println(" 3. Teach the animal new command(s)");
            System.out.println(" 4. All animals by date of birth, starting from the oldest");
            Integer n = getValidNumber("Enter the number of action -> ", 5);
            System.out.println("Yes! " + n);
        }

            private static Integer getValidNumber (String invitation, int max) {
                String input = prompt(invitation);
                if (col.toolkit.isDigit(input)) {
                    Integer target = Integer.parseInt(input);
                    if ((target >= 0) && (target < max)) {
                        return target;
                    }
                }
                invitation = "Not valid input. Enter valid number -> ";
                return getValidNumber(invitation, max);
            }

        public static String prompt (String message) {
            Scanner input = new Scanner(System.in);
            System.out.print(message);
            return input.nextLine();
    }

        //     }      
        // }
        // Integer number = 0;
        // for(String groupName: accordance.values()) {
        //     if (!(groupNumbers.containsValue(groupName))) {
        //         groupNumbers.put(number, groupName);
        //         number ++;
        //     }
        // }

        // HashMap<String, Integer> groups = new HashMap<>();
        // groups.put("Pet", 0);
        // groups.put("PackAnimal", 1);


        // System.out.println(groupNumbers.toString());
        // String l = "00 04 PackAnimal Donkey Osel Sancho|Pansa 1825-02-23 Сидеть|Бежать";
        // Toolkit tk = new Toolkit();
        // System.out.println(tk.lineCheck(l, accordance, groupNumbers));
        
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

    protected static ArrayList<Animal> getTypes() {
        ArrayList<Animal> allTypes = new ArrayList<>();
        allTypes.add(new Cat("Cat"));
        allTypes.add(new Dog("Dog"));
        allTypes.add(new Hamster("Hamster"));
        allTypes.add(new Horse("Horse"));
        allTypes.add(new Camel("Camel"));
        allTypes.add(new Donkey("Donkey"));
        return allTypes;
    }
    public static HashMap<Integer, String> getReady (HashMap<String, String> accordance) {
        HashMap<Integer, String> groupNumbers = new HashMap<>();
        ArrayList<Animal> allKinds = getTypes();
        Integer groupId = 0;
        for(int i = 0; i < allKinds.size(); i++) {
            allKinds.get(i).setGroup(accordance);
            if (!(groupNumbers.containsValue(allKinds.get(i).getGroupName()))) {
                groupNumbers.put(groupId, allKinds.get(i).getGroupName());
                groupId ++;
            }
        }
        return groupNumbers;
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