package base.util;

import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

import base.util.attachment.Triviality;
import base.util.attachment.Checker;
import base.util.dbAssistants.DBConnector;
import base.util.dbAssistants.DBTranslator;
import varieties.Animal;

public class Toolkit extends Triviality implements Checker {

    public Toolkit () {}

    @Override
    public boolean isDigit (String subject) {
        try {
            Integer.parseInt(subject);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isDate (int year, int month, int dayOfMonth) {
        try {
            LocalDate.of(year, month, dayOfMonth);
            return true;
        }
        catch (DateTimeException e) {
            return false;
        }
    }

    @Override
    public boolean lineCheck (String line,
            HashMap<String, String> groupAccordance,
            HashMap<Integer, String> groupsNumbers) {
        String[] dataItems = line.split(" ");
        int correctAmount = 8;
        if (dataItems.length == correctAmount) {
            int groupIdIndex = 0;
            int idInGroupIndex = 1;
            if (isDigit(dataItems[groupIdIndex]) && (isDigit(dataItems[idInGroupIndex]))) {
                int groupNameIndex = 2;
                if (groupsNumbers.containsValue(dataItems[groupNameIndex])) {
                    Integer groupNum = Integer.valueOf(dataItems[groupIdIndex]);
                    if (groupsNumbers.get(groupNum).equals(dataItems[groupNameIndex])) {
                        int typeIndex = 3;
                        if (groupAccordance.containsKey(dataItems[typeIndex])) {
                            if (groupAccordance.get(dataItems[typeIndex]).equals(dataItems[groupNameIndex])) {
                                int dateIndex = 6;
                                try {
                                    LocalDate.parse(dataItems[dateIndex]);
                                    return true;
                                } catch (DateTimeParseException e) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public Animal reborn (String line, ArrayList<Animal> allTypes,
            HashMap<String, String> groupAccordance,
            HashMap<Integer, String> groupsNumbers, int index) {
        String[] dataArray = line.split(" ");
        ArrayList<Animal> animals = allTypes;
        Animal target = getAnimal(animals, dataArray[3]);
        target.setGroup(groupAccordance);
        target.setGroupId(groupsNumbers);
        target.name = dataArray[4];
        target.owner = dataArray[5];
        String[] dateNumbers = dataArray[6].split("-");   
        int year = Integer.parseInt(dateNumbers[0]);
        int month = Integer.parseInt(dateNumbers[1]);
        int day = Integer.parseInt(dateNumbers[2]);
        LocalDate birthDate = LocalDate.of(year, month, day);
        target.setBirthDate(birthDate);
        target.setCommands(dataArray[7]);
        int idInt = Integer.parseInt(dataArray[1]);
        Integer id = Integer.valueOf(idInt);
        target.setId(id);
        target.setSeat(index);
        return target;
    }
}
