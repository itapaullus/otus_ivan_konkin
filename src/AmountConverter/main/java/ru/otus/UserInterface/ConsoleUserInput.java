package AmountConverter.main.java.ru.otus.UserInterface;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleUserInput implements UserInput {
    private final Scanner scanner;

    public ConsoleUserInput(InputStream in) {
        this.scanner = new Scanner(in);
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public Integer getInteger() {
        return Integer.parseInt(scanner.nextLine().trim());
    }
}