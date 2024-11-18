package varieties;
import java.time.LocalDate;

public abstract class Animal {
    public int groupId;
    public String groupName;
    public String type;
    public String name;
    public String owner;
    public static LocalDate birthDate;
    static {
        birthDate = LocalDate.of(2005, 11, 25);
    }
    public Animal() {}
    public void setType(String typeName) {
        this.type = typeName;
    }
    public void setCommands(String commands) {};
    public String toString() {
        // Нужна переменная, в которую будут сохраняться
        // испорченные данные и если она не равна null, то
        // вернётся она, а не то, что тут сейчас указано
        return groupName + " " + birthDate + " " + type + " " + groupId;
    }
}
