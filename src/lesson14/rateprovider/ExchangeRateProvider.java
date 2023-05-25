package lesson14.rateprovider;

public interface ExchangeRateProvider {
    Double getRate(String curFrom, String curTo) throws NoRateException;
}
