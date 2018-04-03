package com.m3c.md.sorters;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sortRandom() {
        Integer[] arr = {7, 2, 3, 9, 4};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);

        assertEquals("[2, 3, 4, 7, 9]", Arrays.toString(arr));
    }

    @Test
    public void sortReverse() {
        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", Arrays.toString(arr));
    }

    @Test
    public void alreadySorted() {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(arr));
    }

    @Test
    public void emptyInput() {
        Integer[] arr = {};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);
        assertEquals("[]", Arrays.toString(arr));
    }

    @Test
    public void sortDuplicates() {
        Integer[] arr = {23, 10, 3, 10, 4, 9, 12};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);
        assertEquals("[3, 4, 9, 10, 10, 12, 23]", Arrays.toString(arr));
    }

    @Test
    public void sortSingleElement() {
        Integer[] arr = {2, 2, 2, 2, 2};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);
        assertEquals("[2, 2, 2, 2, 2]", Arrays.toString(arr));
    }

    @Test
    public void sortRandomString() {
        String[] arr = {"asd", "basd", "cwe", "awe", "vasd"};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);
        assertEquals("[asd, awe, basd, cwe, vasd]", Arrays.toString(arr));
    }

    @Test
    public void alreadySortedChar() {
        String[] arr = {"b", "b", "b", "b", "b"};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);
        assertEquals("[b, b, b, b, b]", Arrays.toString(arr));
    }

    @Test
    public void reverseChar() {
        String[] arr = {"e", "d", "c", "b", "a"};
        System.out.print(Arrays.toString(arr) + " -> ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.print(arr);
        assertEquals("[a, b, c, d, e]", Arrays.toString(arr));
    }
}