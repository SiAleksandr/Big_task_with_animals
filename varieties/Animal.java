package varieties;
import java.time.LocalDate;
import java.util.Map;

public abstract class Animal {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String commands;

    // public Animal(Long id, String name, LocalDate birthDate, String commands, Long seat) {
    public Animal(Informer one) {
        this.id = one.id;
        this.name = one.name;
        this.gender = one.gender;
        this.birthDate = one.birthDate;
        this.commands = one.commands;
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

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String getCommands() {
        return commands;
    }

    public String toString() {
        return getId().toString() + " " + getGroup() + " " + getType() + " " 
        +  name + " " + gender + " " + birthDate.toString() + " " + commands;
    }
    
    public String toView() {
        return toString().replace('|', ' ');
    }
}
