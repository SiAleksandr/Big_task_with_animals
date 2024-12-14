package base;

import base.util.Toolkit;
import base.util.dbAssistants.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import varieties.Animal;

public class Collector {

    private DBConnector connector;
    private DBTranslator translator;
    public Toolkit toolkit;
    public HashMap<Integer, String> groupNumbers;
    public ArrayList<String> bigList;
    public ArrayList<String> corruptedData;

    public Collector () {
        toolkit = new Toolkit();
    }

    public boolean startWork() {
        connector = new DBConnector();
        try {
            connector.createDb();
        }
        catch(Exception e) {
            System.out.println("the storage creation failed");
            return false;
        }
        translator = new DBTranslator(connector.fileName);
        try {
            bigList = translator.getList(connector.fileName);
        }
        catch(IOException e) {
            System.out.println("the storage reading failed.");
            return false;
        }
        return true;
    }

    public void getReady (HashMap<String, String> accordance, ArrayList<Animal> allKinds) {
        groupNumbers = new HashMap<>();
        Integer groupId = 0;
        for(int i = 0; i < allKinds.size(); i++) {
            allKinds.get(i).setGroup(accordance);
            if (!(groupNumbers.containsValue(allKinds.get(i).getGroupName()))) {
                groupNumbers.put(groupId, allKinds.get(i).getGroupName());
                groupId ++;
            }
        }

    }

    public ArrayList<Animal> rebornAll (HashMap<String, String> accordance,
    ArrayList<Animal> allKinds) {
        ArrayList<Animal> animals = new ArrayList<>();
        corruptedData = new ArrayList<>();
        for(int index = 0; index < bigList.size(); index++) {
            if(toolkit.lineCheck(bigList.get(index), accordance, groupNumbers)) {
                Animal item = toolkit.reborn(bigList.get(index),
                allKinds, accordance, groupNumbers, index);
                Integer currentId = setIdForNew(animals, item);
                item.setId(currentId);
                item.setSeat(index);
                animals.add(item);
            }
            else corruptedData.add(bigList.get(index));
        }
        return animals;
    }

    public Integer setIdForNew (ArrayList<Animal> animalList, Animal item) {
        Integer maxId = 0;
        for (int a = 0; a < animalList.size(); a++) {
            if (animalList.get(a).getGroupId() == item.getGroupId()) {
                if (animalList.get(a).getId() > maxId) {
                    maxId = animalList.get(a).getId() + 1;
                }
            }
        }
        return maxId;
    }

    public void saveAll () {
        try{
        translator.writeFile(bigList, false);
        }
        catch(IOException e) {
            System.out.println("Запись в файл не получилась");
        }
    }
}
