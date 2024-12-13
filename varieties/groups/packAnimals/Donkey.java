package varieties.groups.packAnimals;

import varieties.groups.PackAnimal;

public class Donkey extends PackAnimal {
    public String donkeyCommands;
    
    public Donkey(String type) {
        super(type);
    }

    @Override
    public void setCommands(String commands) {
        donkeyCommands = commands;
    }

    @Override
    public void addCommand(String command) {
        donkeyCommands += " " + command;
    }

    @Override
    public String getCommands () {
        return donkeyCommands;
    }

    public String toString() {
        String commandsModified = donkeyCommands.replace(' ', '|');
        return super.toString() + " " + commandsModified;
    }
}
