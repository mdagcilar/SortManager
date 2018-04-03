package com.m3c.md.display;

import java.util.Arrays;

public class DisplayManager {

    public static <T extends Comparable<T>> void displayUnsortedArray(String sorter, T[] array) {
        System.out.println("Sort using: " + sorter);
        System.out.println("Initial Array: " + Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void displaySortedArray(T[] array) {
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }


    public void displayExceptionMessage(String message) {
        System.out.println(message);
    }
}