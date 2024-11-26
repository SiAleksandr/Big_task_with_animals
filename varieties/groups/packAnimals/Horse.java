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

    public String toString() {
        String commandsModified = horseCommands.replace(' ', '|');
        return super.toString() + " " + commandsModified;
    }
}