package AmountConverter;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner console = new Scanner(System.in);

    @Override
    public void firstScreen() {
        showMessage("     _____                                                      _____");
        showMessage("  __|_    |__  ____    __  _____  __   _  ____   _    __     __|___  |__  _____  ____   _  __    _ ______  _____    __    ______  _____");
        showMessage(" |    \\      ||    \\  /  |/     \\|  | | ||    \\ | | _|  |_  |   ___|    |/     \\|    \\ | |\\  \\  //|   ___||     | _|  |_ |   ___||     |");
        showMessage(" |     \\     ||     \\/   ||     ||  |_| ||     \\| ||_    _| |   |__     ||     ||     \\| | \\  \\// |   ___||     \\|_    _||   ___||     \\");
        showMessage(" |__|\\__\\  __||__/\\__/|__|\\_____/|______||__/\\____|  |__|   |______|  __|\\_____/|__/\\____|  \\__/  |______||__|\\__\\ |__|  |______||__|\\__\\");
        showMessage("    |_____|                                                    |_____|");
    }

    @Override
    public void showMenu() {
        showMessage("");
        showMessage("Choose an option:");
        showMessage("C: Convert amount to string");
        showMessage("Q: Quit");
    }

    private int getAmount() throws BadAmountException {
        showMessage("Enter the amount:");
        int amount;
        try {
            amount = console.nextInt();
        } catch (Exception e) {
            console.nextLine();
            throw new BadAmountException("Incorrect amount!");
        }
        if (0 <= amount && amount < 1000000) {
            return amount;
        } else {
            throw new BadAmountException("Only amount between 0 and 999.999 supported");
        }
    }

    private Currency getCurrency() throws BadCurrencyException {
        showMessage("Enter the currency");
        try {
            return Currency.valueOf(console.next());
        } catch (IllegalArgumentException e) {
            throw new BadCurrencyException("This currency doesn't supported at the moment");
        }
    }

    @Override
    public void returnResult(String text) {
        showMessage(text);
    }

    private Action getAction() throws NoActionException {
        try {
            return Action.fromString(console.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new NoActionException("Option not found");
        }
    }

    private void showMessage(String text) {
        System.out.println(text);
    }

    private void showError(String text) {
        System.err.println(text);
    }

    @Override
    public Action getActionWithRetry() {
        try {
            return getAction();
        } catch (NoActionException e) {
            showError(e.getMessage());
            return getActionWithRetry();
        }
    }

    @Override
    public Currency getCurrencyWithRetry() {
        try {
            return getCurrency();
        } catch (BadCurrencyException e) {
            showError(e.getMessage());
            return getCurrencyWithRetry();
        }
    }

    @Override
    public int getAmountWithRetry() {
        try {
            return getAmount();
        } catch (BadAmountException e) {
            showError(e.getMessage());
            return getAmountWithRetry();
        }
    }
}
