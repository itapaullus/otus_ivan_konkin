package lesson12.sorter;

import java.util.ArrayList;

public class SelectionSorter implements Sorter {
    @Override
    public void sort(ArrayList<Integer> array) {
        int j;
        for (int i = 0; i < array.size() - 1; i++) {
            int minN = i;
            Integer minValue = array.get(minN);
            for (j = i + 1; j < array.size(); j++) {
                if (minValue > array.get(j)) {
                    minN = j;
                    minValue = array.get(j);
                }
            }
            array.set(minN, array.get(i));
            array.set(i, minValue);
        }
    }
}
