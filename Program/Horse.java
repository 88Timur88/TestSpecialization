import java.time.LocalDate;
import java.util.Set;

public class Horse extends PackAnimals {
    public Horse(String name, LocalDate birthday) {
        super(name, birthday, AnimalsType.Horse);
    }

    public Horse(String name, LocalDate birthday, Set<String> commands) {
        super(name, birthday, commands, AnimalsType.Horse);
    }
}
