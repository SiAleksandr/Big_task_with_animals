package varieties;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Animal {
    public Integer seat;
    public Integer groupId;
    public String groupName;
    public String type;
    public String name;
    public String owner;
    public LocalDate birthDate;

    public Animal(String type) {
        this.type = type;
        this.seat = null;
    }

    public void setGroup(HashMap<String, String> accordance) {
        groupName = accordance.get(type);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupId(HashMap<Integer, String> groups) {
        for(Integer i = 0; i < groups.size(); i++) {
            if(groups.get(i).equals(groupName)) {
                groupId = i;
                i = groups.size();
            }
        }
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

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public void setCommands(String commands) {}

    public void addCommand(String command) {}

    public String toString() {
        String nameModified = name.replace(' ', '|');
        String ownerModified = owner.replace(' ', '|');
        return groupName + " " + type + " " + nameModified + " "
        + ownerModified + " " + birthDate.toString();
    }
}
