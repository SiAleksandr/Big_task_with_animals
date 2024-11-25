package varieties.groups.pets;

import varieties.groups.Pet;

public class Cat extends Pet {
    public String catCommands;

    public Cat(String type) {
        super(type);
    }
    
    @Override
    public void setCommands(String commands) {
        catCommands = commands;
    }

    @Override
    public void addCommand (String newCommand) {
        catCommands += " " + newCommand;
    }

    public String toString() {
    String commandsModified = catCommands.replace(' ', '|');
    return super.toString() + " " + commandsModified;
    }
}
