import java.time.LocalDate;
import java.util.Set;

public class Donkey extends PackAnimals {
    public Donkey(String name, LocalDate birthday) {
        super(name, birthday, AnimalsType.Donkey);
    }

    public Donkey(String name, LocalDate birthday, Set<String> commands) {
        super(name, birthday, commands, AnimalsType.Donkey);
    }
}
