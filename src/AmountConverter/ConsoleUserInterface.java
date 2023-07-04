package AmountConverter;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner console = new Scanner(System.in);

    @Override
    public void firstScreen() {
        System.out.println("     _____                                                      _____");
        System.out.println("  __|_    |__  ____    __  _____  __   _  ____   _    __     __|___  |__  _____  ____   _  __    _ ______  _____    __    ______  _____");
        System.out.println(" |    \\      ||    \\  /  |/     \\|  | | ||    \\ | | _|  |_  |   ___|    |/     \\|    \\ | |\\  \\  //|   ___||     | _|  |_ |   ___||     |");
        System.out.println(" |     \\     ||     \\/   ||     ||  |_| ||     \\| ||_    _| |   |__     ||     ||     \\| | \\  \\// |   ___||     \\|_    _||   ___||     \\");
        System.out.println(" |__|\\__\\  __||__/\\__/|__|\\_____/|______||__/\\____|  |__|   |______|  __|\\_____/|__/\\____|  \\__/  |______||__|\\__\\ |__|  |______||__|\\__\\");
        System.out.println("    |_____|                                                    |_____|");
    }

    @Override
    public void showMenu() {
        System.out.println();
        System.out.println("Choose an option:");
        System.out.println("C: Convert amount to string");
        System.out.println("Q: QUit");
    }

    @Override
    public int getAmount() {
        System.out.println("Enter the amount:");
        return console.nextInt();
    }

    @Override
    public Currency getCurrency() {
        System.out.println("Enter the currency: only RUR supported");
        return Currency.valueOf(console.next());
    }

    @Override
    public void returnResult(String text) {
        System.out.println(text);
    }

    @Override
    public Action getAction() throws NoActionException {
        try {
            return Action.fromString(console.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new NoActionException("Option not found");
        }
    }

    @Override
    public void showMessage(String text) {
        System.out.println(text);
    }

    @Override
    public void showError(String text) {
        System.err.println(text);
    }
}
