package com.m3c.md.controller;

import com.m3c.md.display.DisplayManager;
import com.m3c.md.sorters.Sorter;

import java.util.Arrays;
import java.util.Random;

public class SortManager {

    public void sortArray() {
        Integer[] arrayToSort = createIntegerArray(1000);
        Sorter sorter = SortFactory.getInstance();

        DisplayManager.displayUnsortedArray(sorter.toString(), arrayToSort);

        long startTime = System.nanoTime();
        sorter.sort(arrayToSort);
        long endTime = System.nanoTime();
        DisplayManager.displaySortedArray(arrayToSort, (endTime - startTime));
    }


    private Integer[] createIntegerArray(int size) {
        Random random = new Random();
        Integer[] unsortedArray = new Integer[size];

        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size * 10) + 1;
        }
        return unsortedArray;
    }


//    public void sortStringArray() {
//        String[] arrayToSort = createCharArray(10);
//        Sorter sorter = SortFactory.getInstance();
//
//        System.out.println("\nInitial Array: " + Arrays.toString(arrayToSort) + "\n");
//        sorter.sort(arrayToSort);
//        System.out.println("Sorted Array: " + Arrays.toString(arrayToSort));
//    }
//
//    private String[] createCharArray(int size) {
//        Random random = new Random();
//        String[] unsortedArray = new String[size];
//
//        for (int i = 0; i < size; i++) {
//            unsortedArray[i] = String.valueOf((char) (random.nextInt(10) + 1));
//        }
//
//        return unsortedArray;
//    }
}