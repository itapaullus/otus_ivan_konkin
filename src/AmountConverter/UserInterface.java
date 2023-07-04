package AmountConverter;

public interface UserInterface {

    void firstScreen();

    void showMenu();

    void returnResult(String text);

    Action getActionWithRetry();

    Currency getCurrencyWithRetry();

    int getAmountWithRetry();
}
