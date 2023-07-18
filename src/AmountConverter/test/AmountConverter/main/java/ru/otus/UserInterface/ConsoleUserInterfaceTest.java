package AmountConverter.main.java.ru.otus.UserInterface;

import AmountConverter.main.java.ru.otus.Enum.Action;
import AmountConverter.main.java.ru.otus.Enum.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ConsoleUserInterfaceTest {

    @Test
    @DisplayName("Check action input from console menu")
    void getActionWithRetry() {
        List<String> fails = new ArrayList<>();
        UserInput userInput = new ConsoleUserInput(new ByteArrayInputStream(("""
                asd
                Q
                123
                Convert
                C""").getBytes()));

        class UserOutputTest extends ConsoleUserOutput {
            @Override
            public void showError(String string) {
                super.showError(string);
                fails.add(string);
            }
        }
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(userInput, new UserOutputTest());
        Assertions.assertEquals(consoleUserInterface.getActionWithRetry(), Action.QUIT);
        Assertions.assertEquals(consoleUserInterface.getActionWithRetry(), Action.CONVERT);
        Assertions.assertEquals(fails, new ArrayList<>(Arrays.asList("Option not found", "Option not found", "Option not found")));
    }

    @Test
    @DisplayName("Check Currency input from console UI")
    void getCurrencyWithRetry() {
        List<String> fails = new ArrayList<>();
        UserInput userInput = new ConsoleUserInput(new ByteArrayInputStream(("""
                asd

                RUR
                рубли
                USD""").getBytes()));
        class TestUserOutput extends ConsoleUserOutput {
            @Override
            public void showError(String string) {
                super.showError(string);
                fails.add(string);
            }
        }
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(userInput, new TestUserOutput());
        Assertions.assertEquals(consoleUserInterface.getCurrencyWithRetry(), Currency.RUR);
        Assertions.assertEquals(consoleUserInterface.getCurrencyWithRetry(), Currency.USD);
        Assertions.assertEquals(fails, new ArrayList<>(Arrays.asList("This currency doesn't supported at the moment", "This currency doesn't supported at the moment", "This currency doesn't supported at the moment")));
    }

    @Test
    void getAmountWithRetry() {
        List<String> fails = new ArrayList<>();
        UserInput userInput = new ConsoleUserInput(new ByteArrayInputStream(("""
                1234567
                -50
                123456
                0
                asdfg
                465""").getBytes()));

        class TestUserOutput extends ConsoleUserOutput {
            @Override
            public void showError(String string) {
                super.showError(string);
                fails.add(string);
            }
        }

        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(userInput, new TestUserOutput());
        Assertions.assertEquals(consoleUserInterface.getAmountWithRetry(), 123456);
        Assertions.assertEquals(consoleUserInterface.getAmountWithRetry(), 0);
        Assertions.assertEquals(consoleUserInterface.getAmountWithRetry(), 465);
        Assertions.assertEquals(fails, new ArrayList<>(Arrays.asList("Only amount between 0 and 999.999 supported", "Only amount between 0 and 999.999 supported", "Incorrect amount!")));
    }
}