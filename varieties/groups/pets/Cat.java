package varieties.groups.pets;
import varieties.groups.Pet;

public class Cat extends Pet {
    public String catCommands;
    Cat() {
        super();
    }
    public void setCatCommands(String commands) {
        this.catCommands = commands;
        return;
    }
    public void addCatComands (String newCommand) {
        this.catCommands += newCommand;
        return;
    }
}
