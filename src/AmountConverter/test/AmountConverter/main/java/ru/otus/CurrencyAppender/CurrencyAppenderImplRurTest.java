package AmountConverter.main.java.ru.otus.CurrencyAppender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CurrencyAppenderImplRurTest {

    private final CurrencyAppenderImplRur currencyAppender = new CurrencyAppenderImplRur();

    @ParameterizedTest(name = "{index} => {0}({1}): {2}")
    @CsvFileSource(resources = "/numbers.csv", numLinesToSkip = 1)
    void appendCurrency(int number, String dummy, String appender) {
        Assertions.assertEquals(appender, currencyAppender.appendCurrency(number));
    }
}