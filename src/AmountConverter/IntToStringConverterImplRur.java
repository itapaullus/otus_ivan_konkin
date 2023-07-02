package AmountConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntToStringConverterImplRur implements IntToStringConverter{
    private static final String[] UNITS = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String[] TEENS = {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] HUNDREDS = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[] THOUSANDS = {"", "тысяча", "тысячи", "тысяч"};
    @Override
    public String convert(Integer amount) {
         StringBuilder result = new StringBuilder();
         int thousands = amount / 1000;
         int remainder = amount % 1000;
         return convertToWords(remainder,false);
    }

    private static String convertToWords(int num, boolean isThousand) {
        if (num == 0){
            return "ноль";
        }
        int hundreds = num / 100;
        int units = num % 10;
        int tens = (num % 100) / 10;
        StringBuilder res = new StringBuilder();
        System.out.println(hundreds + " " + tens + " " + units);
        if (hundreds > 0) {
            res.append(HUNDREDS[hundreds]).append(" ");
        }
        if (tens==1 && units>0){
            res.append(TEENS[units]).append(" ");
        } else {
            if (tens > 0) {
                res.append(TENS[tens]).append(" ");
            }
            if (units > 0) {
                res.append(UNITS[units]).append(" ");
            }
        }

        return res.toString().trim();
    }
}
