package com.m3c.md.model;

import com.m3c.md.controller.SortFactory;
import com.m3c.md.controller.SortManagerException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Sort algorithms test suite.
 * Please change the key 'sorter' in 'factory.properties' to each sorting algorithm. (bubble, merge, quick or binarytree)
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class SortTest {

    private static Sorter sorter;
    private Integer[] unsortedArray, sortedArray;
    private Random random = new Random();

    @BeforeClass
    public static void setClass() throws SortManagerException {
        sorter = SortFactory.getInstance();

        System.out.println("Testing using the " + sorter.toString());
    }

    @Before
    public void setup() {
        // if sorter is an instance of BinaryTree, create a new instance
        // each time. To ensure nodes have been removed from previous tests.
        if (sorter.getClass() == BinaryTreeImpl.class) {
            sorter = new BinaryTreeImpl();
        }

        // create random array
        unsortedArray = new Integer[10];
        for (int i = 0; i < 10; i++) {
            unsortedArray[i] = random.nextInt(10 * 10) + 1;
        }
        sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
    }

    @Test
    public void sortRandom() {
        Arrays.sort(sortedArray);
        sorter.sort(unsortedArray);

        assertArrayEquals(sortedArray, unsortedArray);
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

    /**
     * Testing for a large input case, against Arrays.sort() implementation
     */
    @Test
    public void sortLargeInput() {
        Integer[] arr = {-1, -4, 3, 10, 0, 9, 12, 4, 6, 5, 19, 8, 6, 12, 7, 3, 1, 20, 15, 13, 6};

        Integer[] arraysSort = {-1, -4, 3, 10, 0, 9, 12, 4, 6, 5, 19, 8, 6, 12, 7, 3, 1, 20, 15, 13, 6};
        Arrays.sort(arraysSort);

        sorter.sort(arr);

        assertArrayEquals(arraysSort, arr);
    }

    @Test
    public void sortRandomString() {
        //TODO: temporarily ignore String Test cases for BinaryTrees. Need to fix this
        if (sorter.getClass() == BinaryTreeImpl.class) {
            return;
        }

        String[] arr = {"asd", "basd", "cwe", "awe", "vasd"};

        sorter.sort(arr);

        assertEquals("[asd, awe, basd, cwe, vasd]", Arrays.toString(arr));
    }

    @Test
    public void alreadySortedChar() {
        //TODO: temporarily ignore String Test cases for BinaryTrees. Need to fix this
        if (sorter.getClass() == BinaryTreeImpl.class) {
            return;
        }

        String[] arr = {"b", "b", "b", "b", "b"};

        sorter.sort(arr);

        assertEquals("[b, b, b, b, b]", Arrays.toString(arr));
    }

    @Test
    public void reverseChar() {
        //TODO: temporarily ignore String Test cases for BinaryTrees. Need to fix this
        if (sorter.getClass() == BinaryTreeImpl.class) {
            return;
        }

        String[] arr = {"e", "d", "c", "b", "a"};

        sorter.sort(arr);

        assertEquals("[a, b, c, d, e]", Arrays.toString(arr));
    }
}