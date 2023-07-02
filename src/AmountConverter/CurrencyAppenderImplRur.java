package AmountConverter;

public class CurrencyAppenderImplRur implements CurrencyAppender{
    @Override
    public String appendCurrency(int Amount, Currency currency) {
        return "рублей";
    }
}
