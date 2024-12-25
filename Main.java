import varieties.Animal;
import varieties.groups.pets.*;
import varieties.groups.packAnimals.*;
import base.*;
import view.View;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.io.EOFException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
        // List<String> bl = new ArrayList<>();
        // String line = "Kh hdh jjfd";
        // bl.add(line);
        // line = "0 Pet Cat Pussy Sasha|Petrov 2015-02-23 Sit|Pounce";
        // bl.add(line);
        // line = "1 PackAnimal Camel Smor Karabas|barabas 2012-05-17 Walk|CarryLoad";
        // bl.add(line);
        // line = "2 PackAnimal Donkey Kozo Sancho 2020-01-19 Walk|CarryLoad|Bray";
        // bl.add(line);
        // line = "Ля ля ля";
        // bl.add(line);
        // line = "3 Pet Cat Frosya Nina|Sikalova 2017-10-13 Scratch|Meow";
        // bl.add(line);
        // line = "4 Pet Cat Inessa Alexandr|Sagalov 2018-11-26 Meow|Scratch|Jump";
        // bl.add(line);
        // line = "5 Pet Dog Juna Konstantin|Kuznetsov 2000-06-07 Sit|Voice";
        // bl.add(line);

        // try {
        //     AnimalList main = rebornAll(accordance, allTypes, bl);

        //     // for(int i = 0; i < main.size(); i++) {
        //     //     System.out.println(main.get(i).getSeat());
        //     //     System.out.println(main.get(i).toString());
        //     // }
        //     main.get(main.size() - 1).setMark();
        //     System.out.println(main.get(0).toString());
        // } catch (Exception e) {
        //     System.out.println("Error");
        // }




        // Long i = 2L;
        // Animal a = reborn(line, allTypes, accordance, i);
        // System.out.println(a.getOwner());
        // System.out.println(a.getCommands());
        // System.out.println(a.getSeat());
        // System.out.println(a.toString());      
    //     return allTypes;
    // }

    // public static AnimalList rebornAll(Map<String, String> accordance,
    // AnimalList allKinds, List<String> bigList) throws Exception {
    //     if(bigList.size() == 0) throw new Exception();
    //     int current = -1;
    //     int i = 0;
    //     while(i < bigList.size()) {
    //         if(lineCheck(bigList.get(i), accordance)) {
    //             current = i;
    //             i = bigList.size();
    //         }
    //         else i++;
    //     }
    //     if(current == -1) throw new Exception();
    //     String lineFirst = bigList.get(current);
    //     Long index = Long.valueOf(current);
    //     Animal animalFirst = reborn(lineFirst, allKinds, accordance, index);
    //     animalFirst.setMark();
    //     AnimalList mainList = new AnimalList(animalFirst);
    //     current++;
    //     index++;
    //     while(current < bigList.size()) {
    //         if(lineCheck(bigList.get(current), accordance)) {
    //             Animal item = reborn(bigList.get(current),
    //             allKinds, accordance, index);
    //             item.setMark();
    //             mainList.get(mainList.size() - 1).setMark();
    //             mainList.add(item);
    //         }
    //         current++;
    //         index++;
            // else corruptedData.add(bigList.get(index));
        // }
        // ArrayList<Animal> results = new ArrayList<>();
        // for(Integer i = 0; i < suitable.size(); i++) {
        //     results.add(toolkit.reborn(bigList.get(suitable.get(i)),
        //     allKinds, accordance, this.groupNumbers, suitable.get(i)));
        //     System.out.println(results.get(results.size() - 1).toString());
        // test {
        // for(Integer t = 0; t < results.size(); t++)
        // System.out.println(results.get(t));
        // test }
    //     return mainList;
    // }

    // public static Animal getAnimal(AnimalList types, String typeName) {
    //     int target = 0;
    //     int i = 0;
    //     while (i < types.size()) {
    //         if (types.get(i).getType().equals(typeName)) {
    //             target = i;
    //             i = types.size(); // Чтобы выйти из цикла
    //         }
    //         else i++;
    //     }
    //     return types.get(target);
    // }



    // public static boolean isDigit (String subject) {
    //     try {
    //         Integer.parseInt(subject);
    //         return true;
    //     }
    //     catch (NumberFormatException e) {
    //         return false;
    //     }
    // }
// }
