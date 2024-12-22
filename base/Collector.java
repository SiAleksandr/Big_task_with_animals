package base;

import base.util.Check;
import base.util.dbAssistants.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import varieties.Animal;

public class Collector {
    public List<String> corruptedData;
    private DBConnector connector;
    private DBTranslator translator;

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
        String fileName = connector.getFileName();
        try {
            List<String> currentList = translator.getList(fileName);
            return currentList;
        } catch (IOException e) {
            System.out.println("file reading failed");
            return new ArrayList<String>();
        }
    }

    public boolean saveList(List<String> lines, DBTranslator use) {
        try {
            use.writeFile(lines, false);
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
