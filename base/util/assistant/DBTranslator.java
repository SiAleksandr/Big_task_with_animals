package base.util.assistant;

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
    public void writeFile(ArrayList<String> list) throws IOException {
        FileWriter fw = new FileWriter(this.fileName, false);
        for (String line: list) {
            line += '\n';
            fw.write(line);
        }
        fw.flush();
        fw.close();
    }
}
