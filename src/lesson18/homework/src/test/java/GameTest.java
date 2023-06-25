package lesson18.homework.src.test.java;

import lesson18.homework.src.main.java.ru.otus.game.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("Проверка на равные значения")
    public void testEqualsResult() {
        class TestWinnerPrinter implements GameWinnerPrinter {
            public String winnerName;

            @Override
            public void printWinner(Player winner) {
                this.winnerName = winner.getName();
            }
        }
        class EqualDice implements Dice { //всегда возвращаем 1
            @Override
            public int roll() {
                return 1;
            }
        }
        Dice dice = new EqualDice();
        TestWinnerPrinter winnerPrinter = new TestWinnerPrinter();
        Game game = new Game(new EqualDice(), winnerPrinter);
        game.playGame(new Player("player1"), new Player("player2"));
        // проверим, что игра не вернет ни первого, ни второго игрока
        Assertions.assertNotEquals(winnerPrinter.winnerName, "player1");
        Assertions.assertNotEquals(winnerPrinter.winnerName, "player2");
    }
}
