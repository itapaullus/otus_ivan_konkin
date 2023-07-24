package lesson12.sorter;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSorter implements Sorter {
    @Override
    public void sort(ArrayList<Integer> array) {
        Collections.sort(array);
    }
}
