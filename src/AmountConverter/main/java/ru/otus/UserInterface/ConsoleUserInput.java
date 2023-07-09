package AmountConverter.main.java.ru.otus.UserInterface;

import AmountConverter.main.java.ru.otus.Exception.BadAmountException;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleUserInput implements UserInput {
    private final Scanner console;

    public ConsoleUserInput(InputStream in) {
        this.console = new Scanner(in);
    }

    @Override
    public String getString() {
        return console.nextLine();
    }

    @Override
    public Integer getInteger() throws BadAmountException {
        return Integer.parseInt(console.nextLine().trim());
    }
}