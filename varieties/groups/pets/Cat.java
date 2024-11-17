package varieties.groups.pets;
import varieties.groups.Pet;

public class Cat extends Pet {
    public String catCommands;
    public Cat() {
        super();
    }
    @Override
    public void setCommands(String commands) {
        this.catCommands = commands;
    }
    public void addComand (String newCommand) {
        this.catCommands += " " + newCommand;
        return;
    }
    @Override
    public String toString() {
        return super.toString() + " " + catCommands;
    }
}
