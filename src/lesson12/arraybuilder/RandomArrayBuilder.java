package lesson12.arraybuilder;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayBuilder implements ArrayBuilder {
    @Override
    public ArrayList<Integer> generate(int size, int maxValue) {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(maxValue));
        }
        return array;
    }
}
