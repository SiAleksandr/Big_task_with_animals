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

    public Collector () {}

    public void startWork() {
        connector = new DBConnector();
        try {
            connector.createDb();
        }
        catch(Exception e) {
            System.out.println("Конектор ошибся");
        }
        translator = new DBTranslator(connector.fileName);
        try {
            bigList = translator.getList(connector.fileName);
        }
        catch(IOException e) {
            System.out.println("Транслятор ошибся");
        }
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
        toolkit = new Toolkit();
        ArrayList<Animal> animals = new ArrayList<>();
        corruptedData = new ArrayList<>();
        for(int index = 0; index < bigList.size(); index++) {
            if(toolkit.lineCheck(bigList.get(index), accordance, groupNumbers)) {
                Animal item = toolkit.reborn(bigList.get(index),
                allKinds, accordance, groupNumbers, index);
                animals.add(item);
            }
            else corruptedData.add(bigList.get(index));
        }
        return animals;
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
