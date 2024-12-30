package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.util.Attachment;
import base.util.Collector;
import varieties.Animal;

public class Service {
    public Attachment transform;
    public Collector source;
    public List<String> bigList;
    public List<String> corruptedData;

    public Service() {
        transform = new Attachment();
        source = new Collector();
        bigList = new ArrayList<>();
        corruptedData = new ArrayList<>();
    }

    public boolean start() {
        return source.startWork();
    }

    public void generateLists(Map<String, String> accordance) {
        List<String> all = source.readDB();
        for(int i = 0; i < all.size(); i++) {
            if (transform.lineCheck(all.get(i), accordance)) {
                bigList.add(all.get(i));
            }
            else {
                corruptedData.add(all.get(i));
            }
        }

    }
    public void describeNewAnimal() {
    }

    public List<String> sameTypeSearch (String typeName) {
        List<String> target = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            String[] parts = bigList.get(i).split(" ");
            if (parts[2].equals(typeName)) {
                target.add(bigList.get(i));
            }
        }
        return target;
    }

    public List<String> nameSearch(List<String> inputList, String name) {
        List<String> target = new ArrayList<>();
        for(String item: inputList) {
            String[] parts = item.split(" ");
            if(parts[3].equals(name)) {
                target.add(item);
            }
        }
        return target;
    }
    
    public String idSearch(List<String> inputList, String inputId) {
        String target = null;
        for(String item: inputList) {
            String[] parts = item.split(" ");
            if(inputId.equals(parts[0])){
                target = item;
            }
        }
        return target;
    }

    public void saveNewCommand(Animal target) {
        String id = target.getId().toString();
        for(int i = 0; i < bigList.size(); i++) {
            String[] parts = bigList.get(i).split(" ");
            if(parts[0].equals(id)) {
                bigList.set(i, target.toString());
                i = bigList.size();
            }
        }
        boolean justAdd = false;
        source.saveList(bigList, source.translator, justAdd);
    }
}
