package AmountConverter.main.java.ru.otus.UserInterface;

import AmountConverter.main.java.ru.otus.Exception.BadAmountException;

public interface UserInput {
    String getString();

    Integer getInteger() throws BadAmountException;
}
