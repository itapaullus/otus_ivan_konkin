package AmountConverter;

public class IntToStringConverterImplRur implements IntToStringConverter {
    private static final String[] UNITS = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String[] TEENS = {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] HUNDREDS = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[] THOUSANDS = {"", "тысяча", "тысячи", "тысяч"};

    private static String convertToWords(int num, boolean isThousand) {
        if (num == 0) {
            return "";
        }
        int hundreds = num / 100;
        int units = num % 10;
        int tens = (num % 100) / 10;
        StringBuilder res = new StringBuilder();
        if (hundreds > 0) {
            res.append(HUNDREDS[hundreds]).append(" ");
        }
        if (tens == 1 && units > 0) {
            res.append(TEENS[units]).append(" ");
        } else {
            if (tens > 0) {
                res.append(TENS[tens]).append(" ");
            }
            if ((units == 1 || units == 2) && isThousand) {
                res.append(units == 1 ? "одна" : "две").append(" ");
            } else if (units > 0) {
                res.append(UNITS[units]).append(" ");
            }
        }
        // добавим слово "тысяч"
        if (isThousand && units > 0) {
            if (units == 1) {
                res.append(THOUSANDS[1]).append(" ");
            } else if (units < 5) {
                res.append(THOUSANDS[2]).append(" ");
            }
        } else if (isThousand) {
            res.append(THOUSANDS[3]).append(" ");
        }
        return res.toString().trim();
    }

    @Override
    public String convert(Integer amount) {
        String str;
        if (amount == 0) {
            return "ноль";
        }
        int thousands = amount / 1000;
        int remainder = amount % 1000;
        if (thousands > 0 && remainder == 0) {
            str = convertToWords(thousands, true);
        } else {
            str = convertToWords(thousands, true) + " " + convertToWords(remainder, false);
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
