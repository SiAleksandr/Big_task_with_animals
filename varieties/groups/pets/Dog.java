package varieties.groups.pets;

import varieties.groups.Pet;

public class Dog extends Pet {
    public String dogCommands;

    public Dog(String type) {
        super(type);
    }
    
    @Override
    public void setCommands(String Commands) {
        dogCommands = Commands;
    }

    public String toString() {
        String commandsModified = dogCommands.replace(' ', '|');
        return super.toString() + " " + commandsModified;
    }
}
