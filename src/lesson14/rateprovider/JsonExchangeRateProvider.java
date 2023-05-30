package lesson14.rateprovider;

import lesson14.model.CurrencyPair;
//import org.json.JSONArray;
//import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JsonExchangeRateProvider implements ExchangeRateProvider {
    private final String filename;
    private Map<CurrencyPair, Double> rates;

    public JsonExchangeRateProvider(String filename) {
        this.filename = filename;
        this.rates = new HashMap<>();
    }

    private Double getRate(CurrencyPair pair) throws NoRateException {
        Double result = rates.get(pair);
        if (result == null) {
            parseExchangeRates();
        }
        result = rates.get(pair);
        if (result == null) {
            throw new NoRateException("Currency pair "+pair.curFrom()+"/"+pair.curTo()+" doesn't exists");
        }
        else {
            return result;
        }
    }

    @Override
    public Double getRate(String curFrom, String curTo) throws NoRateException {
        return getRate(new CurrencyPair(curFrom, curTo));
    }

    private void parseExchangeRates() {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filename))){
            byte[] jsonData = inputStream.readAllBytes();

//            так как парсить тут json немного лень, да и заивисимости без pom подключать неудобно,
//            то просто зашьем в мапу гвоздями несколько ставок
            rates.put(new CurrencyPair("USD", "RUR"), 81.25);
            rates.put(new CurrencyPair("EUR", "RUR"), 87.18);
        } catch (IOException e) {
            throw new RuntimeException("Invalid path");
        }
    }
}
