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

    public String toString() {
        String commandsModified = hamsterCommands.replace(' ', '|');
        return super.toString() + " " + commandsModified;
    }
}
