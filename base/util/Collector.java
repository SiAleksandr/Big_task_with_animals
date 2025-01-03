package base.util;

import base.util.dbAssistants.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import varieties.Animal;

public class Collector {
    private DBConnector connector;
    public DBTranslator translator;

    public Collector () {
        connector = new DBConnector();
        translator = new DBTranslator(connector.getFileName());
    }

    public boolean startWork() {
        try {
            connector.createDb();
            return true;
        }
        catch(Exception e) {
            System.out.println("the storage creation failed");
            return false;
        }
    }

    public List<String> readDB() {
        try {
            List<String> currentList = translator.getList();
            return currentList;
        } catch (IOException e) {
            System.out.println("file reading failed");
            return new ArrayList<String>();
        }
    }

    public boolean saveList(List<String> lines, DBTranslator use, boolean join) {
        try {
            use.writeFile(lines, join);
            return true;
        } catch (IOException e) {
            System.out.println("saving to a file failed");
            return false;
        }
    }

    // public Integer setIdForNew (ArrayList<Animal> animalList, Animal item) {
    //     Integer maxId = 0;
    //     for (int a = 0; a < animalList.size(); a++) {
    //         if (animalList.get(a).getGroupId() == item.getGroupId()) {
    //             if (animalList.get(a).getId() > maxId) {
    //                 maxId = animalList.get(a).getId() + 1;
    //             }
    //         }
    //     }
    //     return maxId;
    // }
}
