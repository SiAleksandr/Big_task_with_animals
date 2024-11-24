package base.util.dbAssistants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DBTranslator {
    public String fileName;
    public DBTranslator(String fileName) {
        this.fileName = fileName;
    }
    public ArrayList<String> getList(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String line;
        ArrayList<String> linesList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            linesList.add(line);
        }
        br.close();
        return linesList;
    }
    public void writeFile(ArrayList<String> list, boolean continuation) throws IOException {
        FileWriter fw = new FileWriter(this.fileName, continuation);
        for (String line: list) {
            fw.write(line);
            fw.append('\n');
        }
        fw.flush();
        fw.close();
    }
}
