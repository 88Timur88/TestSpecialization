import java.time.LocalDate;
import java.util.Set;

public class PackAnimals extends Animal {
    protected PackAnimals(String name, LocalDate birthday, AnimalsType type) {
        super(name, birthday, type);
    }

    protected PackAnimals(String name, LocalDate birthday, Set<String> commands, AnimalsType type) {
        super(name, birthday, commands, type);
    }
}
