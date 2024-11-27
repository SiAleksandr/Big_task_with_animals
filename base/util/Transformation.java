package base.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import base.util.addition.Preparer;
import base.util.dbAssistants.DBConnector;
import base.util.dbAssistants.DBTranslator;
import varieties.Animal;

public class Transformation implements Preparer {
    public DBConnector connector;
    public DBTranslator translator;

    public Transformation(DBConnector connector, DBTranslator translator) {
        this.connector = connector;
        this.translator = translator;
    }
    @Override
        public Animal getAnimal(ArrayList<Animal> types, String someType) {
        int target = 0;
        int i = 0;
        while (i < types.size()) {
            if (types.get(i).type.equals(someType)) {
                target = i;
                i = types.size(); // Чтобы выйти из цикла
            }
            else i++;
        }
        return types.get(target);
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
    
    public ArrayList<String> getStringList(ArrayList<Animal> animals) {
        ArrayList<String> simpleEntries = new ArrayList<>();
        for(Animal one: animals) {
            simpleEntries.add(one.toString());
        }
        return simpleEntries;
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
