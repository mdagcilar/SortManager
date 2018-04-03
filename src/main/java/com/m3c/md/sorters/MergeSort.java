package com.m3c.md.sorters;

import java.util.Arrays;

/**
 * Implementation of the MergeSort algorithm
 *
 * @author  Metin Dagcila
 * @version 1.0
 * @since   2018-04-03
 */

public class MergeSort implements Sorter {

    public <T extends Comparable<T>> void sort(T[] inputArray) {
        if (inputArray == null || inputArray.length < 2) return;

        int mid = inputArray.length / 2;
        T[] leftArr = Arrays.copyOfRange(inputArray, 0, mid);
        T[] rightArr = Arrays.copyOfRange(inputArray, mid, inputArray.length);

        sort(leftArr);
        sort(rightArr);

        merge(leftArr, rightArr, inputArray);
    }

    private <T extends Comparable<T>> void merge(T[] left, T[] right, T[] result) {
        int i = 0, j = 0;

        while (i + j < result.length) {
            if (j == right.length || (i < left.length && left[i].compareTo(right[j]) < 0))
                result[i + j] = left[i++];
            else
                result[i + j] = right[j++];
        }
    }

    public <T extends Comparable<T>> void print(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public String toString(){
        return "Merge Sorter";
    }
}