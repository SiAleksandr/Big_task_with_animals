package base.util.dbAssistants;

import java.io.File;

public class DBConnector {
    public static String fileName;
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
    // System.out.println("An error occurred while file using.");
}
