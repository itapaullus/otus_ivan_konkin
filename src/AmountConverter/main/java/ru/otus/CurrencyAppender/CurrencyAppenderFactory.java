package AmountConverter.main.java.ru.otus.CurrencyAppender;

import AmountConverter.main.java.ru.otus.Enum.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyAppenderFactory {
    private final static Map<Currency, CurrencyAppender> currencyAppenderMap = new HashMap<>();

    public CurrencyAppenderFactory() {
        for (Currency cur : Currency.values()) {
            currencyAppenderMap.put(cur, createCurrencyAppender(cur));
        }
    }

    public static CurrencyAppender createCurrencyAppender(Currency currency) {
        if (currency.equals(Currency.RUR)) {
            return new CurrencyAppenderImplRur();
        } else if (currency.equals(Currency.USD)) {
            return new CurrencyAppenderImplUSD();
        } else {
            throw new IllegalArgumentException("Invalid Currency Code");
        }
    }

    public CurrencyAppender getCurrencyAppender(Currency currency) {
        return currencyAppenderMap.get(currency);
    }
}
