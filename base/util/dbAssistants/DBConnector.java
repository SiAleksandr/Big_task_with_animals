package base.util.dbAssistants;

import java.io.File;

public class DBConnector {
    private static String fileName;
    {fileName = "db.txt";}
    public static void createDb() throws Exception {
        File db = new File(fileName);
        if (db.createNewFile()) {
            System.out.println("file db.txt created");
        }
        else {
            System.out.println("file db.txt already exists");
        }
    }

    public static String getFileName() {
        return fileName;
    }
}
