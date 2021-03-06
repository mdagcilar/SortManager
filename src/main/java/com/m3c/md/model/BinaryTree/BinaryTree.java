package com.m3c.md.model.BinaryTree;

import java.util.List;

/**
 * BinaryTree interface
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public interface BinaryTree {

    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ElementNotFoundException;

    int getRightChild(int element) throws ElementNotFoundException;

    List<Integer> getSortedTreeAsc();

    List<Integer> getSortedTreeDesc();
}