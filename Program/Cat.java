import java.time.LocalDate;
import java.util.Set;

public class Cat extends Pets {
    public Cat(String name, LocalDate birthday) {
        super(name, birthday, AnimalsType.Cat);
    }

    public Cat(String name, LocalDate birthday, Set<String> commands) {
        super(name, birthday, commands, AnimalsType.Cat);
    }
}
