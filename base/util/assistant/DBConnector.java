package base.util.assistant;

import java.io.File;

public class DBConnector {
    public static final String listFile = "db.txt";
    public static void createDb() throws Exception {
        File db = new File(listFile);
        if (db.createNewFile()) {
            System.out.println("file db.txt created");
        }
        else {
            System.out.println("file db.txt already exists");
        }
    }
    // System.out.println("An error occurred while file using.");
}
