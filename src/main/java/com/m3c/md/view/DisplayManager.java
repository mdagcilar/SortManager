package com.m3c.md.view;

import java.util.Arrays;

/**
 * DisplayManager, responsible for displaying information to the user
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class DisplayManager {

    public static <T extends Comparable<T>> void displayUnsortedArray(String sorter, T[] array) {
        System.out.println("Sort using: " + sorter);
        System.out.println("Initial Array: " + Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void displaySortedArray(T[] array) {
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void displayExceptionMessage(String message) {
        System.out.println(message);
    }
}