package AmountConverter;

public class BadCurrencyException extends Exception {
    BadCurrencyException(String message) {
        super(message);
    }
}
