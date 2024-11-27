package base.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import base.util.attachment.Triviality;
import base.util.attachment.Checker;
import base.util.dbAssistants.DBConnector;
import base.util.dbAssistants.DBTranslator;
import varieties.Animal;

public class Toolkit extends Triviality implements Checker {
    public DBConnector connector;
    public DBTranslator translator;

    public Toolkit(DBConnector connector, DBTranslator translator) {
        this.connector = connector;
        this.translator = translator;
    }

    @Override
    public boolean lineCheck (String line, ArrayList<Animal> allTypes,
            HashMap<String, String> groupAccordance,
            HashMap<String, Integer> groupsNumbers) {
        String[] dataItems = line.split(" ");
        int correctAmount = 8;
        if (dataItems.length == correctAmount) {

        }


        
        return true;
    }
    

    public Animal reborn (String line, ArrayList<Animal> allTypes,
            HashMap<String, String> groupAccordance,
            HashMap<String, Integer> groupsNumbers) {
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
        return target;
    }
}
