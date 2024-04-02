package lesson14;

import lesson14.converter.SimpleCurrencyConverter;
import lesson14.rateprovider.JsonExchangeRateProvider;
import lesson14.ui.ConsoleUserInterface;

public class App {
    public static void main(String[] args) {
        ConverterApp converterApp = new ConverterApp(new SimpleCurrencyConverter(),
                new JsonExchangeRateProvider("src/lesson14/resources/rates/rates.json"),
                new ConsoleUserInterface()
        );
        converterApp.app();
    }
}
