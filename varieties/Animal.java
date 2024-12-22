package varieties;
import java.time.LocalDate;
import java.util.Map;

public abstract class Animal {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String commands;
    private Long seat;

    // public Animal(Long id, String name, LocalDate birthDate, String commands, Long seat) {
    public Animal(Informer one) {
        this.id = one.id;
        this.name = one.name;
        this.birthDate = one.birthDate;
        this.commands = one.commands;
        this.seat = one.seat;
    }

    public Long getId() {
        return id;
    }

    public String getGroup() {
        return null;
    }

    public String getType() {
        return null;
    }

    public String getName () {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void addCommand(String command) {
        commands += command;
    }

    public String getCommands() {
        return commands;
    }

    public Long getSeat() {
        return seat;
    }

    public String toString() {
        return getId().toString() + " " + getGroup() + " " + getType() + " " 
        +  name + " " + birthDate.toString() + " " + commands;
    }
}
