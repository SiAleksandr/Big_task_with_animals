package base.util;

import java.time.LocalDate;
import java.util.ArrayList;

import base.util.dbAssistants.DBConnector;
import base.util.dbAssistants.DBTranslator;
import base.util.tools.AnimalInitialization;
import varieties.Animal;

public class Transformation {
    public DBConnector connector;
    public DBTranslator translator;
    public AnimalInitialization animalInitialization;

    public Transformation(DBConnector connector, DBTranslator translator,
    AnimalInitialization  animalInitialization) {
        this.connector = connector;
        this.translator = translator;
        this.animalInitialization = animalInitialization;
    }
    
    public ArrayList<String> getStringList(ArrayList<Animal> animals) {
        ArrayList<String> simpleEntries = new ArrayList<>();
        for(Animal one: animals) {
            simpleEntries.add(one.toString());
        }
        return simpleEntries;
    }

    public Animal reborn (String line) {
        String[] dataArray = line.split(" ");
        ArrayList<Animal> animals = animalInitialization.allTypes;
        Animal target = animalInitialization.getAnimal(animals, dataArray[3]);
        target.setGroup(animalInitialization.groupAccordance);
        target.setGroupId(animalInitialization.groupsNumbers);
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
