package lesson12.tester;

import lesson12.arraybuilder.RandomArrayBuilder;
import lesson12.sorter.Sorter;

import java.util.ArrayList;

public class SortTest {
    private final Sorter sorter;
    private final int size;
    private final int maxValue;
    public void run() {
        ArrayList<Integer> array = new RandomArrayBuilder().generate(size,maxValue);
        long startTime = System.currentTimeMillis();
        sorter.sort(array);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Array with size "+size+" have been sorted during "+timeTaken+" ms");
    }

    public SortTest(Sorter sorter, int size, int maxValue) {
        this.sorter = sorter;
        this.size = size;
        this.maxValue = maxValue;
    }
}
