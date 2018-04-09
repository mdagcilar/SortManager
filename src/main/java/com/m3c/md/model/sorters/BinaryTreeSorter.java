package com.m3c.md.model.sorters;

import com.m3c.md.model.BinaryTree.BinaryTree;
import com.m3c.md.model.BinaryTree.BinaryTreeImpl;

/**
 * BinaryTreeSorter
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class BinaryTreeSorter implements Sorter {

    /**
     * Sorts elements using getSortedTreeAsc() and converts it to an array.
     * <p>
     * Returns an array containing all of the elements in this list in proper sequence
     * (from first to last element) applied to the sorted list - getSortedTreeAsc().
     *
     * @param elements - array of type T
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] elements) {
        if (elements.length == 0) return;

        BinaryTree binaryTree = new BinaryTreeImpl((Integer) elements[0]);

        int[] elementsToAdd = new int[elements.length - 1];

        for (int i = 1; i < elements.length; i++) {
            elementsToAdd[i - 1] = (Integer) elements[i];
        }

        binaryTree.addElements(elementsToAdd);

        binaryTree.getSortedTreeAsc().toArray(elements);
    }

    @Override
    public String toString() {
        return "BinaryTree Sorter";
    }
}
