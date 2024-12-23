package base.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import varieties.*;
import varieties.groups.pets.*;
import varieties.groups.packAnimals.*;

public class Attachment {
    public Check check;


    public Attachment() {
        check = new Check();
    }

    public boolean lineCheck (String line,
        Map<String, String> groupAccordance) {
        String[] dataItems = line.split(" ");
        int correctAmount = 6;
        if (dataItems.length == correctAmount) {
            if (check.isDigit(dataItems[0])) {
                if (groupAccordance.containsValue(dataItems[1])) {
                    if (groupAccordance.containsKey(dataItems[2])) {
                        if (groupAccordance.get(dataItems[2]).equals(dataItems[1])) {
                            try {
                                LocalDate.parse(dataItems[4]);
                                return true;
                            } catch (DateTimeParseException e) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public Animal reborn (String line, Long index) {
        String[] dataArray = line.split(" ");
        Long id = Long.parseLong(dataArray[0]);
        LocalDate birthDate = LocalDate.parse(dataArray[4]);
        Informer informer = new Informer(id, dataArray[3], 
                birthDate, dataArray[5], index);
        String classType = dataArray[2];
        switch (classType) {
            case ("Cat"):
                return new Cat(informer);

            case ("Dog"):
                return new Dog(informer);

            case ("Hamster"):
                return new Hamster(informer);

            case ("Horse"):
                return new Horse(informer);

            case ("Camel"):
                 return new Camel(informer);

            default:
            return new Donkey(informer);
        }
    }
}
