package com.m3c.md.controller;

import com.m3c.md.display.DisplayManager;
import com.m3c.md.model.Sorter;

import java.util.Arrays;
import java.util.Random;

/**
 * SortManager
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class SortManager {

    public void sortArray() {
        DisplayManager displayManager = new DisplayManager();

        try {
            Sorter sorter = SortFactory.getInstance();
            Integer[] arrayToSort = createIntegerArray(10);

            DisplayManager.displayUnsortedArray(sorter.toString(), arrayToSort);
            sorter.sort(arrayToSort);

            DisplayManager.displaySortedArray(arrayToSort);
        } catch (SortManagerException e) {
            displayManager.displayExceptionMessage(e.getMessage());
        }
    }


    private Integer[] createIntegerArray(int size) {
        Random random = new Random();
        Integer[] unsortedArray = new Integer[size];

        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size * 10) + 1;
        }
        return unsortedArray;
    }

    // *************************************************************************
    // Methods for Sorting with Strings
    // *************************************************************************

    public void sortStringArray() {
        String[] arrayToSort = createCharArray(10);

        try {
            Sorter sorter = SortFactory.getInstance();

            System.out.println("\nInitial Array: " + Arrays.toString(arrayToSort) + "\n");
            sorter.sort(arrayToSort);
            System.out.println("Sorted Array: " + Arrays.toString(arrayToSort));
        } catch (SortManagerException e) {
            e.printStackTrace();
        }
    }

    private String[] createCharArray(int size) {
        Random random = new Random();
        String[] unsortedArray = new String[size];

        for (int i = 0; i < size; i++) {
            unsortedArray[i] = String.valueOf((char) (random.nextInt(10) + 1));
        }

        return unsortedArray;
    }
}