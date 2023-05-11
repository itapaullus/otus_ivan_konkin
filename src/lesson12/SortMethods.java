package lesson12;

import lesson12.sorter.BubbleSorter;
import lesson12.sorter.CollectionsSorter;
import lesson12.sorter.SelectionSorter;
import lesson12.tester.SortTest;

public class SortMethods {
    public static void app() {
        int size = 10000;
        int maxValue = 100000;
        //run bubble sort
        System.out.println("Running Bubble Sorting...");
        new SortTest(new BubbleSorter(), size, maxValue).run();
        //run selection sort
        System.out.println("Running Selection Sorting...");
        new SortTest(new SelectionSorter(), size, maxValue).run();
        //run sorting through Collections.sort()
        System.out.println("Running Collections Sorting...");
        new SortTest(new CollectionsSorter(), size, maxValue).run();
    }
}
