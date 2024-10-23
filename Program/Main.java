import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static RegistrationAnimals aManager;
    private static Scanner in;

    public static void main(String[] args) {
        aManager = new RegistrationAnimals();
        in = new Scanner(System.in);
        while (true) {
            printOperations();
            execOperation(getInt("Введите номер операции, которую хотите осуществить: "));
            getText("Выше находится результат выбранной Вами операции, для продолжения нажмите клавишу Enter");
        }
    }

    public static void printOperations() {
        clearConsole();
        System.out.println("Список доступных операций");
        System.out.println("0. Выход");
        System.out.println("1. Добавление нового животного");
        System.out.println("2. Научить животное новой команде");
        System.out.println("3. Загрузить список ранее введенных животных");
        System.out.println("4. Сохранить введенных животных в общий список");
        System.out.println("5. Вывести список животных");
        System.out.println("6. Вывести список животных, родившихся в определенную дату");
        System.out.println("7. Счетчик животных");

    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public static void execOperation(Integer operation) {
        try {
            switch (operation) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addAnimal();
                    break;
                case 2:
                    addCommand();
                    break;
                case 3:
                    loadAnimals();
                    break;
                case 4:
                    saveAnimals();
                    break;
                case 5:
                    printRegister();
                    break;
                case 6:
                    findAnimal();
                    break;
                case 7:
                    countAnimals();
                    break;
                default:
                    System.out.println("Операции с таким номером нет. Пожалуйста введите номер из списка доступных операций");
                    break;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ошибка");
            e.printStackTrace();
            return;
        }
    }

    protected static Integer getInt() {
        while (true) {
            try {
                return Integer.parseInt(getText());
            } catch (Exception e) {
                System.out.println("Неправильный ввод.");
            }
        }
    }

    protected static Integer getInt(String text) {
        System.out.print(text);
        return getInt();
    }

    protected static LocalDate getDate() {
        while (true) {
            try {
                System.out.println("Введите дату в формате ГГГГ-ММ-ДД");
                return LocalDate.parse(in.nextLine());
            } catch (Exception e) {
                continue;
            }
        }
    }

    protected static String getText() {
        return in.nextLine();
    }

    protected static String getText(String text) {
        System.out.print(text);
        return getText();
    }

    protected static Animal getAnimal() {
        while (true) {
            try {
                System.out.println("Введите новое животное в формате: Тип животного; Имя животного; День рождения животного (в формате ГГГГ-ММ-ДД);");
                return Animal.parse(in.nextLine());
            } catch (Exception e) {
                continue;
            }
        }
    }

    protected static Animal getAnimalIndex() {
        while (true) {
            try {
                return aManager.getRegister().get(getInt("Введите порядковый номер животного, которого хотете обучить новой команде: ") - 1);
            } catch (Exception e) {
                System.out.println("Животного с таким номером не существует");
            }
        }
    }

    public static void printRegister() {
        Integer index = 0;

        System.out.println();
        for (Animal animal : aManager.getRegister()) {
            index += 1;
            String line = animal.toString().replace(";", " ");
            System.out.println(index + ". " + line);
        }
        System.out.println();
    }

    public static void loadAnimals() throws IOException {
        aManager.loadAnimals();
        System.out.println("Загружен список ранее сохраненных животных");
    }

    public static void saveAnimals() throws IOException {
        aManager.saveAnimals();
        System.out.println("Введенные животные сохранены в общий список");
    }

    public static void addAnimal() {
        aManager.addAnimal(getAnimal());
        System.out.println("Новое животное успешно добавленно");
    }

    public static void addCommand() {
        printRegister();
        Animal animal = getAnimalIndex();
        System.out.print("Введите команду для обучения: ");
        String command = getText();
        animal.addCommand(command);
        System.out.println("Животное научилось новой команде");
    }

    public static void findAnimal() {
        LocalDate date = getDate();
        for (Animal animal : aManager.getRegister()) {
            if (animal.getBirthday().compareTo(date) != 0)
                continue;
            String line = animal.toString().replace(";", " ");
            System.out.println(line);
        }
    }

    public static void countAnimals() {
        Integer all = 0, pet = 0, pack = 0;
        for (Animal animal : aManager.getRegister()) {
            all += 1;
            if (animal instanceof Pets)
                pet += 1;
            if (animal instanceof PackAnimals)
                pack += 1;
        }
        System.out.println("Всего: " + all);
        System.out.println("Домашних: " + pet);
        System.out.println("Вьючных: " + pack);
    }
}