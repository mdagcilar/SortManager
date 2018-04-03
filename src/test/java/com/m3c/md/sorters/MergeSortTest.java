package com.m3c.md.sorters;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    Sorter sorter;

    @Before
    public void setup(){
        sorter = new MergeSort();
    }

    @Test
    public void sortRandom() {
        Integer[] arr = {7, 2, 3, 9, 4};

        sorter.sort(arr);

        assertEquals("[2, 3, 4, 7, 9]", Arrays.toString(arr));
    }

    @Test
    public void sortReverse() {
        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};

        sorter.sort(arr);

        assertEquals("[1, 2, 3, 4, 5, 6, 7]", Arrays.toString(arr));
    }

    @Test
    public void alreadySorted() {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        sorter.sort(arr);

        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(arr));
    }

    @Test
    public void emptyInput() {
        Integer[] arr = {};

        sorter.sort(arr);

        assertEquals(0, arr.length);
    }

    @Test
    public void sortDuplicates() {
        Integer[] arr = {23, 10, 3, 10, 4, 9, 12};

        sorter.sort(arr);

        assertEquals("[3, 4, 9, 10, 10, 12, 23]", Arrays.toString(arr));
    }

    @Test
    public void sortSingleElement() {
        Integer[] arr = {2, 2, 2, 2, 2};

        sorter.sort(arr);

        assertEquals("[2, 2, 2, 2, 2]", Arrays.toString(arr));
    }

    @Test
    public void sortNegatives() {
        Integer[] arr = {-1, -4, 3, 10, 0, 9, 12};

        sorter.sort(arr);

        assertArrayEquals(new Integer[]{-4, -1, 0, 3, 9, 10, 12}, arr);
    }

    @Test
    public void sortRandomString() {
        String[] arr = {"asd", "basd", "cwe", "awe", "vasd"};

        sorter.sort(arr);

        assertEquals("[asd, awe, basd, cwe, vasd]", Arrays.toString(arr));
    }

    @Test
    public void alreadySortedChar() {
        String[] arr = {"b", "b", "b", "b", "b"};

        sorter.sort(arr);

        assertEquals("[b, b, b, b, b]", Arrays.toString(arr));
    }

    @Test
    public void reverseChar() {
        String[] arr = {"e", "d", "c", "b", "a"};

        sorter.sort(arr);

        assertEquals("[a, b, c, d, e]", Arrays.toString(arr));
    }
}