import java.time.LocalDate;
import java.util.Set;

public class Pets extends Animal {
    protected Pets(String name, LocalDate birthday, AnimalsType type) {
        super(name, birthday, type);
    }

    protected Pets(String name, LocalDate birthday, Set<String> commands, AnimalsType type) {
        super(name, birthday, commands, type);
    }
}
