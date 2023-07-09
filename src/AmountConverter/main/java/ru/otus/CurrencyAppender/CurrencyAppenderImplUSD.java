package AmountConverter.main.java.ru.otus.CurrencyAppender;

public class CurrencyAppenderImplUSD implements CurrencyAppender {

    @Override
    public String appendCurrency(int Amount) {
        return "долларов США";  // может быть реализовано в дальнейшем
    }
}
