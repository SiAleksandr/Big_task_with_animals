package varieties.groups.packAnimals;

import varieties.groups.PackAnimal;

public class Camel extends PackAnimal {
    public String camelCommands;

    public Camel(String type) {
        super(type);
    }

    @Override
    public void setCommands(String commands) {
        camelCommands = commands;
    }

    @Override
    public void addCommand(String command) {
        camelCommands += " " + command;
    }

    @Override
    public String getCommands () {
        return camelCommands;
    }

    public String toString() {
        String commandsModified = camelCommands.replace(' ', '|');
        return super.toString() + " " + commandsModified;
    }
}
