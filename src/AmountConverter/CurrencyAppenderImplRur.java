package AmountConverter;

public class CurrencyAppenderImplRur implements CurrencyAppender {
    @Override
    public String appendCurrency(int amount) {
        if (amount % 100 > 4 && amount % 100 < 21) {
            return "рублей";
        } else if (amount % 10 == 1) {
            return "рубль";
        } else if (amount % 10 == 2 || amount % 10 == 3 || amount % 10 == 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}
