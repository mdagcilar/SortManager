package com.m3c.md.model;

import com.m3c.md.controller.ElementNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * BinaryTreeImplTest JUnit test cases
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class BinaryTreeImplTest {

    private static BinaryTree binaryTree;

    /**
     * Initialise the BinaryTree with a root element of 5.
     */
    @Before
    public void setup() {
        binaryTree = new BinaryTreeImpl(5);
    }

    // Testing the value is correct for the getRootElement() method
    @Test
    public void getRootElement() {
        binaryTree = new BinaryTreeImpl(8);
        assertEquals(8, binaryTree.getRootElement());
    }

    @Test
    public void getNumberOfElements() {
        binaryTree.addElement(1);
        binaryTree.addElement(9);
        binaryTree.addElement(3);
        assertEquals(4, binaryTree.getNumberOfElements());
    }

    @Test
    public void getNumberOfElementsRoot() {
        assertEquals(1, binaryTree.getNumberOfElements());
    }

    @Test
    public void addElement() {
        assertEquals(1, binaryTree.getNumberOfElements());
        binaryTree.addElement(4);
        assertEquals(2, binaryTree.getNumberOfElements());
    }

    @Test
    public void addElementNull() {
        assertEquals(1, binaryTree.getNumberOfElements());
        binaryTree.addElement(4);
        assertEquals(2, binaryTree.getNumberOfElements());
    }

    @Test
    public void addElements() {
        int[] elements = {4, 7, 8};

        assertEquals(1, binaryTree.getNumberOfElements());
        binaryTree.addElements(elements);
        assertEquals(4, binaryTree.getNumberOfElements());
    }

    @Test
    public void addElementsLargeTree() throws ElementNotFoundException {
        int[] elements = {4, 7, 8, 3, 4, 1, 9, 12, 2, 14, 6, 7, 11, 20, 0};

        assertEquals(1, binaryTree.getNumberOfElements());
        binaryTree.addElements(elements);
        assertEquals(16, binaryTree.getNumberOfElements());

        assertEquals(14, binaryTree.getRightChild(12));
        assertEquals(2, binaryTree.getRightChild(1));
        assertEquals(3, binaryTree.getLeftChild(4));
        assertEquals(6, binaryTree.getLeftChild(7));
    }

    // Finds the first element in the Tree
    @Test
    public void findElementRoot() {
        assertEquals(true, binaryTree.findElement(5));
    }

    // Finds an element in the Tree
    @Test
    public void findElement() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);
        binaryTree.addElement(2);

        assertEquals(true, binaryTree.findElement(4));
    }

    // Finds the leaf Node
    @Test
    public void findElementLeafChild() {
        binaryTree.addElement(4);
        binaryTree.addElement(3);
        binaryTree.addElement(2);
        binaryTree.addElement(1);
        binaryTree.addElement(0);

        assertEquals(true, binaryTree.findElement(0));
    }

    // Asserts false for an element that does not exist in the tree
    @Test
    public void findElementDoesNotExist() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);
        binaryTree.addElement(2);

        assertEquals(false, binaryTree.findElement(1));
    }

    @Test
    public void getLeftChild() throws ElementNotFoundException {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);

        assertEquals(4, binaryTree.getLeftChild(5));
    }

    @Test(expected = ElementNotFoundException.class)
    public void getLeftChildElementNotFound() throws ElementNotFoundException {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);

        binaryTree.getLeftChild(12);
    }

    @Test
    public void getRightChild() throws ElementNotFoundException {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);

        assertEquals(8, binaryTree.getRightChild(5));
    }

    @Test(expected = ElementNotFoundException.class)
    public void getRightChildElementNotFound() throws ElementNotFoundException {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);

        binaryTree.getRightChild(14);
    }


    @Test
    public void getSortedTreeAsc() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);
        binaryTree.addElement(3);
        binaryTree.addElement(2);
        binaryTree.addElement(9);

        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 7, 8, 9);
        assertEquals(expected, binaryTree.getSortedTreeAsc());
    }

    @Test
    public void getSortedTreeAscRoot() {
        List<Integer> expected = Collections.singletonList(5);
        assertEquals(expected, binaryTree.getSortedTreeAsc());
    }

    @Test
    public void getSortedTreeDesc() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);
        binaryTree.addElement(3);
        binaryTree.addElement(2);
        binaryTree.addElement(9);

        List<Integer> expected = Arrays.asList(9, 8, 7, 5, 4, 3, 2);
        assertEquals(expected, binaryTree.getSortedTreeDesc());
    }

    @Test
    public void getSortedTreeDescRoot() {
        binaryTree = new BinaryTreeImpl(2);
        List<Integer> expected = Collections.singletonList(2);

        assertEquals(expected, binaryTree.getSortedTreeDesc());
    }

    @Test
    public void sortRandom() {
        Integer[] arr = {7, 2, 3, 9, 4};

        Sorter sorter = new BinaryTreeImpl(arr);
        sorter.sort(arr);

        assertEquals("[2, 3, 4, 7, 9]", Arrays.toString(arr));
    }
}
