package com.m3c.md.display;

import java.text.DecimalFormat;
import java.util.Arrays;

public class DisplayManager {

    public static void displayUnsortedArray(String sorter, Integer[] array){
        System.out.println("Sort using: " + sorter);
        System.out.println("Initial Array: " + Arrays.toString(array));
    }

    public static void displaySortedArray(Integer[] array, long timeTaken){
        DecimalFormat df = new DecimalFormat("###,###,####");
        System.out.println("Sorted Array: " + Arrays.toString(array));
        System.out.println("Time taken: " + df.format(timeTaken));
    }
}