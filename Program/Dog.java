import java.time.LocalDate;
import java.util.Set;

public class Dog extends Pets {
    public Dog(String name, LocalDate birthday) {
        super(name, birthday, AnimalsType.Dog);
    }

    public Dog(String name, LocalDate birthday, Set<String> commands) {
        super(name, birthday, commands, AnimalsType.Dog);
    }
}
