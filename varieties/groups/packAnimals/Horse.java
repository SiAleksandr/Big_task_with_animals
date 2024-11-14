package varieties.groups.packAnimals;
import varieties.groups.PackAnimal;

public class Horse extends PackAnimal {
    public String horseCommands;
    Horse() {
        super();
    }
    public void setHorseCommands(String commands) {
        this.horseCommands = commands;
        return;
    }
    public void addHorseCommand(String command) {
        this.horseCommands += command;
        return;
    }
}