package lesson18;

import lesson18.homework.src.test.java.DiceImplTest;
import lesson18.homework.src.test.java.GameTest;

public class App {
    public static void main() {
//        Demo.main(null);
        new DiceImplTest().test();
        new GameTest().test();
    }
}
