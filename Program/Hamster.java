import java.time.LocalDate;
import java.util.Set;

public class Hamster extends Pets {
    public Hamster(String name, LocalDate birthday) {
        super(name, birthday, AnimalsType.Hamster);
    }

    public Hamster(String name, LocalDate birthday, Set<String> commands) {
        super(name, birthday, commands, AnimalsType.Hamster);
    }
}