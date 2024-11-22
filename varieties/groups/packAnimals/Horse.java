package varieties.groups.packAnimals;

import varieties.groups.PackAnimal;

public class Horse extends PackAnimal {
    public String horseCommands;
    
    public Horse(String type) {
        super(type);
    }
    @Override
    public void setCommands(String commands) {
        horseCommands = commands;
    }

    @Override
    public void addCommand(String command) {
        horseCommands += " " + command;
    }
    @Override
    public String toString() {
        return super.toString() + " " + horseCommands;
    }
}