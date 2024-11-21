package varieties.groups.pets;
import varieties.groups.Pet;

public class Hamster extends Pet {
    public String hamsterCommands;
    public Hamster(String type) {
        super(type);
    }
    public void setHamsterComands(String commands) {
        this.hamsterCommands = commands;
        return;
    }
    public void addHamsterCommand(String command) {
        this.hamsterCommands += command;
        return;
    }
}
