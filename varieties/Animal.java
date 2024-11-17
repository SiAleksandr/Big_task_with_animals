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
        return groupName + " " + birthDate + " " + type + " " + groupId;
    }
}
