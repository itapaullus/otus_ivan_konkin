package AmountConverter;

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
            this.userInterface.showMenu();
            Action action = userInterface.getActionWithRetry();
            int amount;
            if (action.equals(Action.CONVERT)) {
                amount = userInterface.getAmountWithRetry();
                Currency currency = userInterface.getCurrencyWithRetry();
                String result = intToStringConverter.convert(amount);
                result += " " + currencyAppender.appendCurrency(amount);
                this.userInterface.returnResult(result);
            } else if (action.equals(Action.QUIT)) {
                return;
            }
        }
    }
}
