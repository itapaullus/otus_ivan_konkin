package AmountConverter;

public interface UserInterface {

    void firstScreen();

    void showMenu();

    int getAmount();

    Currency getCurrency();

    void returnResult(String text);

    Action getAction() throws NoActionException;

    void showMessage(String text);

    void showError(String text);
}
