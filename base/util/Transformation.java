package base.util;

import java.util.ArrayList;

import base.util.assistant.DBConnector;
import base.util.assistant.DBTranslator;
import varieties.Animal;

public class Transformation {
    DBConnector connector;
    DBTranslator translator;
    public Transformation(DBConnector connector, DBTranslator translator) {
        this.connector = connector;
        this.translator = translator;
    }
    
    public ArrayList<String> getStringList(ArrayList<Animal> animals) {
        ArrayList<String> simpleEntries = new ArrayList<>();
        for(Animal one: animals) {
            simpleEntries.add(one.toString());
        }
        return simpleEntries;
    }
}
