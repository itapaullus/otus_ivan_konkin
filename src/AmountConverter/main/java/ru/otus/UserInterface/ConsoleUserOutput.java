package AmountConverter.main.java.ru.otus.UserInterface;

public class ConsoleUserOutput implements UserOutput {

    @Override
    public void showMessage(String string) {
        System.out.println(string);
    }

    @Override
    public void showError(String string) {
        System.err.println(string);
    }
}
