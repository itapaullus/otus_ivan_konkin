package AmountConverter.main.java.ru.otus.IntToStringConverter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntToStringConverterImplRurTest {
    private final IntToStringConverterImplRur converter = new IntToStringConverterImplRur();

    @ParameterizedTest
    @CsvFileSource(resources = "/numbers.csv", numLinesToSkip = 1)
    @DisplayName("Check integer to string conversion")
    void convert(int number, String expectedText) {
        String actualText = converter.convert(number);
        assertEquals(expectedText, actualText);
    }
}