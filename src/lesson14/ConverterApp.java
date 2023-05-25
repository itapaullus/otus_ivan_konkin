package lesson14;

import lesson14.converter.CurrencyConverter;
import lesson14.rateprovider.ExchangeRateProvider;
import lesson14.rateprovider.NoRateException;
import lesson14.ui.Action;
import lesson14.ui.InvalidAction;
import lesson14.ui.UserInterface;

public class ConverterApp {
    private final CurrencyConverter converter;
    private final ExchangeRateProvider provider;
    private final UserInterface ui;

    public ConverterApp(CurrencyConverter converter,
                        ExchangeRateProvider provider,
                        UserInterface ui) {
        this.provider = provider;
        this.converter = converter;
        this.ui = ui;
    }

    public void app() {
        while (true) {
            try {
                ui.showMenu();
                Action action = ui.getAction();
                if (action.equals(Action.QUIT)) {
                    break;
                } else if (action.equals(Action.EXCHANGE)) {
                    String curFrom = ui.getCurrency("Enter currency to convert from");
                    String curTo = ui.getCurrency("Enter currency to convert to");
                    double result = converter.convert(ui.getAmount("enter Amount"), provider.getRate(curFrom, curTo));
                    ui.showMessage("Your converted amount is " + curTo + " " + result);
                }
            } catch (NoRateException | InvalidAction | RuntimeException  e) {
                ui.showMessage(e.getMessage());
            }
        }
    }
}
