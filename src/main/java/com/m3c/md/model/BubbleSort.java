package com.m3c.md.model;
import java.util.Arrays;

/** Implementation of the BubbleSort algorithm
 *
 * @author  Metin Dagcilar
 * @version 1.0
 * @since   2018-04-03
 */

public class BubbleSort implements Sorter {

    public <T extends Comparable<T>> void sort(T[] inputArray) {
        boolean swapped = false;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length - i - 1; j++) {
                if (inputArray[j].compareTo(inputArray[j + 1]) > 0) {
                    T tmp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = tmp;
                    swapped = true;
                }
            }
            // no elements were swapped in the last sweep.
            if (!swapped) {
                break;
            }
        }
    }

    public <T extends Comparable<T>> void print(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public String toString(){
        return "Bubble Sorter";
    }
}