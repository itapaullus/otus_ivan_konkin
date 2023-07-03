package AmountConverter;

public class ConsoleUserInterface implements UserInterface{
    @Override
    public void showMenu() {
        System.out.println("menu");
    }

    @Override
    public int getAmount() {
        System.out.println("Введите число, пока тут 123");
        return 61519;
    }

    @Override
    public Currency getCurrency() {
        System.out.println("Curr??");
        return Currency.RUR;
    }

    @Override
    public void returnResult(String text) {
        System.out.println(text);
    }
}
