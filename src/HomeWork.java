import AmountConverter.AmountConverter;
import AmountConverter.main.java.ru.otus.CurrencyAppender.CurrencyAppenderFactory;
import AmountConverter.main.java.ru.otus.IntToStringConverter.IntToStringConverter;
import AmountConverter.main.java.ru.otus.IntToStringConverter.IntToStringConverterImplRur;
import AmountConverter.main.java.ru.otus.UserInterface.ConsoleUserInput;
import AmountConverter.main.java.ru.otus.UserInterface.ConsoleUserInterface;
import AmountConverter.main.java.ru.otus.UserInterface.ConsoleUserOutput;
import AmountConverter.main.java.ru.otus.UserInterface.UserInterface;

public class HomeWork {
    public static void main(String[] args) {
        IntToStringConverter intToStringConverter = new IntToStringConverterImplRur();
        UserInterface userInterface = new ConsoleUserInterface(new ConsoleUserInput(System.in), new ConsoleUserOutput());
        CurrencyAppenderFactory currencyAppenderFactory = new CurrencyAppenderFactory();
        AmountConverter amountConverter = new AmountConverter(userInterface, intToStringConverter, currencyAppenderFactory);
        amountConverter.run();
    }
}
