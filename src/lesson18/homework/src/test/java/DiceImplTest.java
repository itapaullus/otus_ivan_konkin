package lesson18.homework.src.test.java;

import lesson18.homework.src.main.java.ru.otus.game.Dice;
import lesson18.homework.src.main.java.ru.otus.game.DiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiceImplTest {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    @Test
    @DisplayName("Тест на корректность диапазонов значений")
    public void testDicesDiapason() {
        Dice dice = new DiceImpl();
        for (int i = 0; i < 100; i++) {
            int result = dice.roll();
            // если раскомментить этот try-catch, то будет запрашиваемый тест с system.err/system.out.
//            try {
            Assertions.assertTrue(result >= 1 && result <= 6);
            // Если оставить как есть, то более менее полноценный тест, который красиво валится в Идее)
            //System.out.println("Test passed");
//            } catch (AssertionError e) {
//                //System.err.printf("Test Failed: Actual dice - %d", result);
//            }
        }
    }
}