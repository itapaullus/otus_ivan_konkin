package exercises;

/*
Дана строка, состоящая из слов, разделенных пробелами. Необходимо реализовать метод, который возвращает строку, слова в которой записаны в обратном порядке.
 Например, для строки "test abc" необходимо получить строку "abc test".
*/

import java.util.Arrays;
import java.util.Collections;

public class WordUtils {
    public static String reverseWords(String inputText) {
        String[] split = inputText.split(" ");
        Collections.reverse(Arrays.asList(split));
        return String.join(" ", split);
    }

    private WordUtils() {

    }

    public static void main(String[] args) {
        System.out.println("Ввод пустой строки - " + WordUtils.reverseWords(""));
        System.out.println("Ввод одного слова - " + WordUtils.reverseWords("word"));
        System.out.println("Ввод двух слов - " + WordUtils.reverseWords("два слова"));
    }
}