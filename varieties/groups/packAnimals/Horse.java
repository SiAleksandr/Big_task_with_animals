package varieties.groups.packAnimals;
import varieties.groups.PackAnimal;

public class Horse extends PackAnimal {
    public String horseCommands;
    public Horse() {
        super();
    }
    @Override
    public void setCommands(String commands) {
        this.horseCommands = commands;
    }
    public void addCommand(String newCommand) {
        this.horseCommands += " " + newCommand;
        return;
    }
    @Override
    public String toString() {
        return super.toString() + " " + horseCommands;
    }
}