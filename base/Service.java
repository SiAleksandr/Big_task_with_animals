package base;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public Long getNewId () {
        Long max = 0l;
        for(int i = 0; i < bigList.size(); i++) {
            String[] elems = bigList.get(i).split(" ");
            Long current = Long.parseLong(elems[0]);
            if(max < current) {
                max = current;
            }
        }
        return max + 1;
    }

    public void addNewAnimal(Animal newAnimal) {
        bigList.add(newAnimal.toString());
        boolean justAdd = false;
        source.saveList(bigList, source.translator, justAdd);
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

    public String[] organize() {
        LocalDate[] dates = new LocalDate[bigList.size()];
        String[] indexes = new String[bigList.size()];
        for(int i = 0; i < bigList.size(); i++) {
            String[] line = bigList.get(i).split(" ");
            dates[i] = LocalDate.parse(line[5]);
            indexes[i] = String.valueOf(i);
        }
        int maxValid = dates.length - 1;
        for(int n = 0; n < maxValid; n++) {
            for(int k = 0; k < maxValid; k++) {
                if(dates[k].isAfter(dates[k + 1])) {
                    LocalDate temporarilyForDate = dates[k + 1];
                    dates[k + 1] = dates[k];
                    dates[k] = temporarilyForDate;
                    String temporarilyForIndex = indexes[k + 1];
                    indexes[k + 1] = indexes[k];
                    indexes[k] = temporarilyForIndex;
                }
            }
        }
        return indexes;
    }
    public void saveWithCorruptedData () {
        boolean justAdd = false;
        source.saveList(bigList, source.translator, justAdd);
        justAdd = true;
        source.saveList(corruptedData, source.translator, justAdd);
    }
}
