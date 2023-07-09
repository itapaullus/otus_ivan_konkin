package AmountConverter.main.java.ru.otus.UserInterface;

import AmountConverter.main.java.ru.otus.Enum.Action;
import AmountConverter.main.java.ru.otus.Enum.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class ConsoleUserInterfaceTest {

    @Test
    @DisplayName("Check action input from console menu")
    void getActionWithRetry() {
        List<String> fails = new ArrayList<>();     //list for 3 errors
        class UserInputTest extends ConsoleUserInput {
            static final Stack<String> actions = new Stack<>();

            static {
                actions.push("C");
                actions.push("");
                actions.push("Q");
                actions.push("D");
                actions.push("some fail symbol");

            }

            @Override
            public String getString() {
                String res = actions.pop();
                System.out.println("test action input: " + res);
                return res;
            }
        }
        class UserOutputTest extends ConsoleUserOutput {
            @Override
            public void showError(String string) {
                super.showError(string);
                fails.add(string);
            }
        }
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(new UserInputTest(), new UserOutputTest());
        Assertions.assertEquals(consoleUserInterface.getActionWithRetry(), Action.QUIT);
        Assertions.assertEquals(consoleUserInterface.getActionWithRetry(), Action.CONVERT);
        Assertions.assertEquals(fails, new ArrayList<>(Arrays.asList("Option not found", "Option not found", "Option not found")));
    }

    @Test
    @DisplayName("Check Currency input from console UI")
    void getCurrencyWithRetry() {
        List<String> fails = new ArrayList<>();     //list for 3 errors
        class TestUserInput extends ConsoleUserInput {
            static final Stack<String> currencies = new Stack<>();

            static {
                currencies.push("USD");
                currencies.push("рубли");
                currencies.push("RUR");
                currencies.push("");
                currencies.push("asd");
            }

            @Override
            public String getString() {
                String res = currencies.pop();
                System.out.println("test currency input: " + res);
                return res;
            }
        }

        class TestUserOutput extends ConsoleUserOutput {
            @Override
            public void showError(String string) {
                super.showError(string);
                fails.add(string);
            }
        }
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(new TestUserInput(), new TestUserOutput());
        Assertions.assertEquals(consoleUserInterface.getCurrencyWithRetry(), Currency.RUR);
        Assertions.assertEquals(consoleUserInterface.getCurrencyWithRetry(), Currency.USD);
        Assertions.assertEquals(fails, new ArrayList<>(Arrays.asList("This currency doesn't supported at the moment", "This currency doesn't supported at the moment", "This currency doesn't supported at the moment")));
    }

    @Test
    void getAmountWithRetry() {
        List<String> fails = new ArrayList<>();
        class TestUserInput extends ConsoleUserInput {
            static final Stack<String> amounts = new Stack<>();

            static {
                amounts.push("9874");
                amounts.push("654asd");
                amounts.push("");
                amounts.push("asd");
                amounts.push("-5000");
                amounts.push("0");
                amounts.push("999999999");
            }

            @Override
            public Integer getInteger() {
                String res = amounts.pop();
                System.out.println("Test amount input: " + res);
                return Integer.parseInt(res);
            }
        }

        class TestUserOutput extends ConsoleUserOutput {
            @Override
            public void showError(String string) {
                super.showError(string);
                fails.add(string);
            }
        }

        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(new TestUserInput(), new TestUserOutput());
        Assertions.assertEquals(consoleUserInterface.getAmountWithRetry(), 0);
        Assertions.assertEquals(consoleUserInterface.getAmountWithRetry(), 9874);
        Assertions.assertEquals(fails, new ArrayList<>(Arrays.asList(
                "Only amount between 0 and 999.999 supported",
                "Only amount between 0 and 999.999 supported",
                "Incorrect amount!",
                "Incorrect amount!",
                "Incorrect amount!"
        )));
    }
}