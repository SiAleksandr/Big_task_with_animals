package varieties;

import java.time.LocalDate;

public class Informer {
    public Long id;
    public String name;
    public String gender;
    public LocalDate birthDate;
    public String commands;

    public Informer(Long id, String name,
                    String gender,
                    LocalDate birthDate,
                    String commands) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.commands = commands;
    }
}
