package varieties.groups.pets;

import varieties.groups.Pet;

public class Hamster extends Pet {
    public String hamsterCommands;
    
    public Hamster(String type) {
        super(type);
    }

    @Override
    public void setCommands(String commands) {
        hamsterCommands = commands;
    }

    @Override
    public void addCommand(String command) {
        hamsterCommands += " " + command;
    }
}
