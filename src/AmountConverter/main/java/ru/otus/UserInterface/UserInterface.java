package AmountConverter.main.java.ru.otus.UserInterface;

import AmountConverter.main.java.ru.otus.Enum.Action;
import AmountConverter.main.java.ru.otus.Enum.Currency;

public interface UserInterface {

    void firstScreen();

    void showMenu();

    void returnResult(String text);

    Action getActionWithRetry();

    Currency getCurrencyWithRetry();

    int getAmountWithRetry();
}
