package varieties;
import java.time.LocalDate;
import java.util.HashMap;

public abstract class Animal {
    public static int groupId;
    public String groupName;
    public String type;
    public String name;
    public String owner;
    public static LocalDate birthDate;
    static {
        groupId = 0;
        birthDate = LocalDate.of(2005, 11, 25);
    }
    public Animal(String type) {
        this.type = type;
    }

    public void getGroup(HashMap<String, String> accordance) {
        groupName = accordance.get(type);
    }

    public void setCommands(String commands) {};
    public String toString() {
        // Нужна переменная, в которую будут сохраняться
        // испорченные данные и если она не равна null, то
        // вернётся она, а не то, что тут сейчас указано
        return type + " " + groupName + " " + groupId + " " + birthDate;
    }
}
