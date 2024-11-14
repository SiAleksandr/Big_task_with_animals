package varieties.groups.pets;
import varieties.groups.Pet;

public class Dog extends Pet {
    public String dogCommands;
    Dog() {
        super();
    }
    public void setDogCommands(String dogCommands) {
        this.dogCommands = dogCommands;
    }
    public void addDogCommand(String newCommand) {
        this.dogCommands += newCommand;
        return;
    }
}
