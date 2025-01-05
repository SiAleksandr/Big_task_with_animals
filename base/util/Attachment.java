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
        int correctAmount = 7;
        if (dataItems.length == correctAmount) {
            if (check.isDigit(dataItems[0])) {
                if (groupAccordance.containsValue(dataItems[1])) {
                    if (groupAccordance.containsKey(dataItems[2])) {
                        if (groupAccordance.get(dataItems[2]).equals(dataItems[1])) {
                            if (check.isDate(dataItems[5])) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public Informer prepare (String line) {
        String[] dataArray = line.split(" ");
        Long id = Long.parseLong(dataArray[0]);
        LocalDate birthDate = LocalDate.parse(dataArray[5]);
        Informer informer = new Informer(id, dataArray[3],
                dataArray[4], birthDate, dataArray[6]);
        return informer;
    }
}
