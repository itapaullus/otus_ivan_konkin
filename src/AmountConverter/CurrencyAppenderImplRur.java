package AmountConverter;

public class CurrencyAppenderImplRur implements CurrencyAppender{
    @Override
    public String appendCurrency(int amount, Currency currency) {
        if (amount > 4 && amount < 21) {
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
