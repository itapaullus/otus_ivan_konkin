package AmountConverter.main.java.ru.otus.UserInterface;

import AmountConverter.main.java.ru.otus.Exception.BadAmountException;

import java.util.Scanner;

public class ConsoleUserInput implements UserInput {
    private final Scanner console = new Scanner(System.in);

    @Override
    public String getString() {
        return console.nextLine();
    }

    @Override
    public Integer getInteger() throws BadAmountException {
        return Integer.parseInt(console.nextLine().trim());
    }
}