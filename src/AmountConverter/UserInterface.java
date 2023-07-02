package AmountConverter;

public interface UserInterface {
    void showMenu();

    int getAmount();
    Currency getCurrency();

    void returnResult(String text);
}
