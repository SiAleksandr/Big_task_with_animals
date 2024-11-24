package varieties;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Animal {
    public Integer groupId;
    public String groupName;
    public String type;
    public String name;
    public String owner;
    public LocalDate birthDate;

    public Animal(String type) {
        this.type = type;
    }

    public void setGroup(HashMap<String, String> accordance) {
        groupName = accordance.get(type);
    }

    public void setGroupId(HashMap<String, Integer> groups) {
        groupId = groups.get(groupName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(Integer id) {}

    public void setCommands(String commands) {}

    public void addCommand(String command) {}

    public String toString() {
        return type + " " + groupName + " " + groupId + " " + birthDate;
    }
}
