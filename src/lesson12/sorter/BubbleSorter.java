package lesson12.sorter;

import java.util.ArrayList;

public class BubbleSorter implements Sorter {
    @Override
    public void sort(ArrayList<Integer> array) {
        for (int j = array.size() - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array.get(i) > array.get(i + 1)) {
                    Integer temp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, temp);
                }
            }
        }
    }
}
