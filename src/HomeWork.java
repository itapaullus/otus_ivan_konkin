import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class HomeWork {
    public static void main(String[] args) {
//        IntToStringConverter intToStringConverter = new IntToStringConverterImplRur();
//        UserInterface userInterface = new ConsoleUserInterface();
//        CurrencyAppender currencyAppender = new CurrencyAppenderImplRur();
//        AmountConverter amountConverter = new AmountConverter(userInterface, intToStringConverter, currencyAppender);
//        amountConverter.run();
        List<String> jobForPiglet = Arrays.asList("5factory", "Цифрум");
        HashMap<String, Integer> res = new HashMap<>();
        res.put("5factory",0);
        res.put("Цифрум",0);
        System.out.println(jobForPiglet);
        for (int i = 0; i < 13*13*13*11; i++) {
            Random rand = new Random();
            String yourJob = jobForPiglet.get(rand.nextInt(jobForPiglet.size()));
            res.put(yourJob, res.get(yourJob)+1);
        }
        System.out.println("5factory result is "+res.get("5factory"));
        System.out.println("Цифрум result is "+res.get("Цифрум"));
    }
}
