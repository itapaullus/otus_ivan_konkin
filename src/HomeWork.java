import AmountConverter.*;

public class HomeWork {
    public static void main(String[] args) {
        IntToStringConverter intToStringConverter = new IntToStringConverterImplRur();
        UserInterface userInterface = new ConsoleUserInterface();
        CurrencyAppender currencyAppender = new CurrencyAppenderImplRur();
        AmountConverter amountConverter = new AmountConverter(userInterface, intToStringConverter, currencyAppender);
        amountConverter.run();
    }
}
