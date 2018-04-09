package com.m3c.md.model.sorters;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Implementation of the QuickSort algorithm
 * <p>
 * This sort algorithm takes last element as the pivot, places the pivot element
 * at its correct position in sorted array, and places all smaller (smaller than pivot)
 * to left of pivot and all greater elements to right
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class QuickSort implements Sorter {

    private static org.apache.log4j.Logger logger = Logger.getLogger(QuickSort.class);

    @Override
    public <T extends Comparable<T>> void sort(T[] t) {
        logger.info("Unsorted Array " + Arrays.toString(t));
        sort(t, 0, t.length - 1);
    }

    private <T extends Comparable<T>> void sort(T[] inputArray, int low, int high) {

        if (low < high) {
            int pi = partition(inputArray, low, high);

            sort(inputArray, low, pi - 1);
            sort(inputArray, pi + 1, high);
        }
        logger.info("Sorted Array " + Arrays.toString(inputArray));
    }

    private <T extends Comparable<T>> int partition(T[] inputArray, int low, int high) {
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (inputArray[j].compareTo(inputArray[high]) <= 0) {
                i++;

                //swap
                T temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
            }
        }
        T temp = inputArray[i + 1];
        inputArray[i + 1] = inputArray[high];
        inputArray[high] = temp;

        return i + 1;
    }

    @Override
    public String toString() {
        return "Quick Sorter";
    }

//    public <T extends Comparable<T>> void print(T[] arr) {
//        System.out.println(Arrays.toString(arr));
//    }
}