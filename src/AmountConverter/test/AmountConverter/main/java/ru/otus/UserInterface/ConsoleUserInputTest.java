package AmountConverter.main.java.ru.otus.UserInterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class ConsoleUserInputTest {

    @Test
    @DisplayName("Check get integer method")
    void getInteger() {
        ConsoleUserInput consoleUserInput = new ConsoleUserInput(new ByteArrayInputStream("""
                1234
                wrong text
                ///////////
                """.getBytes()));
        Assertions.assertEquals(consoleUserInput.getInteger(), 1234);
        Assertions.assertThrows(NumberFormatException.class, consoleUserInput::getInteger);
        Assertions.assertThrows(NumberFormatException.class, consoleUserInput::getInteger);
    }
}