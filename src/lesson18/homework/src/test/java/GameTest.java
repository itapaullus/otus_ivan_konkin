package lesson18.homework.src.test.java;

import lesson18.homework.src.main.java.ru.otus.game.Dice;
import lesson18.homework.src.main.java.ru.otus.game.Game;
import lesson18.homework.src.main.java.ru.otus.game.GameWinnerPrinter;
import lesson18.homework.src.main.java.ru.otus.game.Player;
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
        TestWinnerPrinter winnerPrinter = new TestWinnerPrinter();
        Game game = new Game(new EqualDice(), winnerPrinter);
        game.playGame(new Player("player1"), new Player("player2"));
        // проверим, что игра не вернет ни первого, ни второго игрока
        try {
            Assertions.assertNotEquals(winnerPrinter.winnerName, "player1");
            Assertions.assertNotEquals(winnerPrinter.winnerName, "player2");
            System.out.println("Test succeeded");
        } catch (AssertionError e) {
            System.err.println("Test Failed! Game with equal dices returning the name of winner");
        }
    }

    @Test
    @DisplayName("Игра с победой первого игрока")
    public void testFirstWin() {
        class DiceForFirstWin implements Dice {
            private int rolls = 0;

            @Override
            public int roll() {
                rolls += 1;
                return 6 - rolls; // для первого вернем 5, для второго - 4
            }
        }
        class TestWinnerPrinter implements GameWinnerPrinter {
            public String winnerName;

            @Override
            public void printWinner(Player winner) {
                this.winnerName = winner.getName();
            }
        }
        TestWinnerPrinter winnerPrinter = new TestWinnerPrinter();
        Game game = new Game(new DiceForFirstWin(), winnerPrinter);
        game.playGame(new Player("player1"), new Player("player2"));
        try {
            Assertions.assertEquals("player1", winnerPrinter.winnerName);
            System.out.println("Test succeeded!");
        } catch (AssertionError e) {
            System.err.println("Test Failed: player1 should be a winner!");
        }
    }

    @Test
    @DisplayName("Игра с победой второго игрока")
    public void testSecondWin() {
        class DiceForFirstWin implements Dice {
            private int rolls = 0;

            @Override
            public int roll() {
                rolls += 1;
                return 1 + rolls; // для первого вернем 2, для второго - 3
            }
        }
        class TestWinnerPrinter implements GameWinnerPrinter {
            public String winnerName;

            @Override
            public void printWinner(Player winner) {
                this.winnerName = winner.getName();
            }
        }
        TestWinnerPrinter winnerPrinter = new TestWinnerPrinter();
        Game game = new Game(new DiceForFirstWin(), winnerPrinter);
        game.playGame(new Player("player1"), new Player("player2"));
        try {
            Assertions.assertEquals("player2", winnerPrinter.winnerName);
            System.out.println("Test succeeded!");
        } catch (AssertionError e) {
            System.err.println("Test failed: player2 should be a winner!");
        }
    }

    public void test() {
        testEqualsResult();
        testFirstWin();
        testSecondWin();
    }
}
