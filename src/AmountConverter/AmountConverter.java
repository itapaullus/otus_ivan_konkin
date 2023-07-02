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
        this.userInterface.showMenu();
        Integer amount = userInterface.getAmount();
        Currency currency = userInterface.getCurrency();
        String result = intToStringConverter.convert(amount);
        result += " "+currencyAppender.appendCurrency(amount, currency);
        this.userInterface.returnResult(result);
    }
}
