package AmountConverter;

import AmountConverter.main.java.ru.otus.CurrencyAppender.CurrencyAppender;
import AmountConverter.main.java.ru.otus.CurrencyAppender.CurrencyAppenderFactory;
import AmountConverter.main.java.ru.otus.Enum.Action;
import AmountConverter.main.java.ru.otus.Enum.Currency;
import AmountConverter.main.java.ru.otus.IntToStringConverter.IntToStringConverter;
import AmountConverter.main.java.ru.otus.UserInterface.UserInterface;

public class AmountConverter {
    private final UserInterface userInterface;
    private final IntToStringConverter intToStringConverter;
    private final CurrencyAppenderFactory currencyAppenderFactory;

    public AmountConverter(UserInterface ui, IntToStringConverter converter, CurrencyAppenderFactory currencyAppenderFactory) {
        this.userInterface = ui;
        this.intToStringConverter = converter;
        this.currencyAppenderFactory = currencyAppenderFactory;
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
                CurrencyAppender currencyAppender = currencyAppenderFactory.getCurrencyAppender(currency);
                String result = intToStringConverter.convert(amount);
                result += " " + currencyAppender.appendCurrency(amount);
                this.userInterface.returnResult(result);
            } else if (action.equals(Action.QUIT)) {
                return;
            }
        }
    }
}
