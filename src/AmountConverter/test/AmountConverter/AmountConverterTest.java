package AmountConverter;

import AmountConverter.main.java.ru.otus.CurrencyAppender.CurrencyAppenderFactory;
import AmountConverter.main.java.ru.otus.Enum.Action;
import AmountConverter.main.java.ru.otus.Enum.Currency;
import AmountConverter.main.java.ru.otus.IntToStringConverter.IntToStringConverterImplRur;
import AmountConverter.main.java.ru.otus.UserInterface.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class AmountConverterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/fulltest.csv", numLinesToSkip = 1)
    @DisplayName("Check full process")
    void run(String action, Integer amount, String currency, String expectedText) {

        class TestUserInterface extends ConsoleUserInterface {
            public String actualResult;
            boolean exit_next_run = false;

            public TestUserInterface(UserInput userInput, UserOutput userOutput) {
                super(userInput, userOutput);
            }

            @Override
            public Action getActionWithRetry() {
                if (exit_next_run) {
                    exit_next_run = false;
                    System.out.println("Q");
                    return Action.QUIT;
                } else {
                    exit_next_run = true;
                    System.out.println(action);
                    return Action.fromString(action);
                }
            }

            @Override
            public int getAmountWithRetry() {
                System.out.println(amount);
                return amount;
            }

            @Override
            public Currency getCurrencyWithRetry() {
                System.out.println(currency);
                return Currency.valueOf(currency);
            }

            @Override
            public void returnResult(String text) {
                super.returnResult(text);
                actualResult = text;
            }
        }
        TestUserInterface ui = new TestUserInterface(new ConsoleUserInput(System.in), new ConsoleUserOutput());
        AmountConverter converter = new AmountConverter(ui,
                new IntToStringConverterImplRur(),
                new CurrencyAppenderFactory()
        );
        converter.run();
        Assertions.assertEquals(expectedText, ui.actualResult);
    }
}