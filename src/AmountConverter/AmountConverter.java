
package AmountConverter;

import java.util.InputMismatchException;

public class AmountConverter {
    private final UserInterface userInterface;
    private final IntToStringConverter intToStringConverter;
    private final CurrencyAppender currencyAppender;

    public AmountConverter(UserInterface ui, IntToStringConverter converter, CurrencyAppender currencyAppender) {
        this.userInterface = ui;
        this.intToStringConverter = converter;
        this.currencyAppender = currencyAppender;
    }

    public void run() {
        this.userInterface.firstScreen();
        while (true) {
            try {
                this.userInterface.showMenu();
                Action action = userInterface.getAction();
                int amount;
                if (action.equals(Action.CONVERT)) {
                    while (true) {
                        try {
                            amount = userInterface.getAmount();
                            break;
                        } catch (Exception ignored) {
                        }
                    }
                    Currency currency = userInterface.getCurrency();
                    String result = intToStringConverter.convert(amount);
                    result += " " + currencyAppender.appendCurrency(amount, currency);
                    this.userInterface.returnResult(result);
                } else if (action.equals(Action.QUIT)) {
                    return;
                }
            }
            catch (IllegalArgumentException | NoActionException e ) {
                userInterface.showError(e.getMessage());
            }
        }
    }
}
