package base.util.dbAssistants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

public class DBTranslator {
    public String fileName;
    public DBTranslator(String fileName) {
        this.fileName = fileName;
    }
    public List<String> getList() throws IOException {
        List<String> linesList = new ArrayList<>();
        String line;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        line = br.readLine();
        if (line != null) linesList.add(line);
        while (line != null) {
            line = br.readLine();
            if(line != null)
                linesList.add(line);
        }
        br.close();
        fr.close();
        return linesList;
    }
    public void writeFile(List<String> list, boolean continuation) throws IOException {
        FileWriter fw = new FileWriter(this.fileName, continuation);
        for (int i = 0; i < list.size(); i++) {
            fw.write(list.get(i));
            fw.append('\n');
        }
        fw.flush();
        fw.close();
    }
}
