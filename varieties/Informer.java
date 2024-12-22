package varieties;

import java.time.LocalDate;

public class Informer {
    public Long id;
    public String name;
    public LocalDate birthDate;
    public String commands;
    public Long seat;

    public Informer(Long id, String name,
                    LocalDate birthDate,
                    String commands, Long seat) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
        this.seat = seat;
    }
}
