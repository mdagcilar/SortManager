package com.m3c.md.model;

import com.m3c.md.controller.ElementNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Metin Dagcilar
 * Date: 06/04/18
 * BinaryTree implementation to add, find and sort elements in a BinaryTree
 */

//TODO: add remove method

public class BinaryTreeImpl implements BinaryTree, Sorter {

    private Node root;
    private int numberOfNodes = 1;      // initialed to 1 because of root node.
    private List<Integer> sortedTreeAsc = new ArrayList<>();
    private List<Integer> sortedTreeDesc = new ArrayList<>();

    // default constructor with no parameters
    public BinaryTreeImpl() {
    }

    // Constructor to initialise the value of Root
    BinaryTreeImpl(final int rootValue) {
        root = new Node(rootValue);
    }

    // Constructor to initialise a Binary tree with an array of elements
    BinaryTreeImpl(Integer[] elements) {
        root = new Node(elements[0]);

        int[] elementsToAdd = new int[elements.length - 1];

        for (int i = 1; i < elements.length; i++) {
            elementsToAdd[i - 1] = elements[i];
        }

        addElements(elementsToAdd);
    }

    // Returns the value of the root Node
    public int getRootElement() {
        return root.getValue();
    }

    // Returns the number of elements in the BinaryTree
    public int getNumberOfElements() {
        return numberOfNodes;
    }

    //Adds a new element to the tree
    public void addElement(final int element) {
        addElementHelper(root, element);
    }

    /**
     * Adds multiple elements at once to the tree with an array of ints
     *
     * @param elements - int array of values to add to the Tree
     */
    public void addElements(int[] elements) {
        //loop through elements and call addElement()
        for (int i : elements) {
            addElementHelper(root, i);
        }
    }

    /**
     * Finds and adds a Node element to the correct position in the BinaryTree
     *
     * @param node    - Node to compare the new adding element to
     * @param element - new Node value to add to the tree
     * @return Node to recursively keep checking the sub tree
     */
    private Node addElementHelper(Node node, int element) {
        if (element <= node.getValue()) {                               // go left
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));                   // add new Node(element)
                numberOfNodes++;
            } else {
                // recursively search the left sub-tree for the correct location
                node.setLeftChild(addElementHelper(node.getLeftChild(), element));
            }
        } else if (node.isRightChildEmpty()) {                          // go right
            // add node
            node.setRightChild(new Node(element));                      // add new Node(element)
            numberOfNodes++;
        } else {
            // recursively search the right sub-tree for the correct location
            node.setRightChild(addElementHelper(node.getRightChild(), element));
        }
        return node;
    }

    /**
     * Finds a Node in the Tree
     *
     * @param value - Node value to search for in the tree.
     * @return - a boolean flag true/false
     */
    public boolean findElement(final int value) {
        return (findNode(root, value) != null &&
                findNode(root, value).getValue() == value);
    }

    /**
     * FindNode locates a Node in the Tree non-recursively and returns the Node
     *
     * @param node  - root node initially, and changes within while loop
     * @param value - value of the Node to be found
     * @return Node object, if found successful otherwise return null
     */
    private Node findNode(Node node, final int value) {
        while (node != null) {
            if (node.getValue() == value) return node;

            if (value < node.getValue()) {          // search left
                node = node.getLeftChild();
            } else if (value > node.getValue()) {   // search right
                node = node.getRightChild();
            }
        }
        return null;
    }

    /**
     * Finds the int value in the Tree and returns it's left child, if exists.
     *
     * @param element - element to find
     * @return - left child of the element
     * @throws ElementNotFoundException throws exception
     */
    public int getLeftChild(int element) throws ElementNotFoundException {
        if (findElement(element)) {
            Node node = findNode(root, element);
            return node.getLeftChild().getValue();
        }
        throw new ElementNotFoundException("Left child of element: " + element + " not found");
    }

    /**
     * Finds the int value in the Tree and returns it's right child, if exists.
     *
     * @param element - element to finds
     * @return - right child of the element
     * @throws ElementNotFoundException throws exception
     */
    public int getRightChild(int element) throws ElementNotFoundException {
        if (findElement(element)) {
            Node node = findNode(root, element);
            return node.getRightChild().getValue();
        }
        throw new ElementNotFoundException("Right child of element: " + element + " not found");
    }

    // Returns a sorted list of the BinaryTree in ascending order
    public List<Integer> getSortedTreeAsc() {
        getSortedTreeAscHelper(root);
        return sortedTreeAsc;
    }

    /**
     * Recursively add the left sub tree to the list
     * Add the root element
     * Recursively add the right sub tree
     *
     * @param node root node
     */
    private void getSortedTreeAscHelper(Node node) {
        if (node != null) {
            getSortedTreeAscHelper(node.getLeftChild());
            sortedTreeAsc.add(node.getValue());
            getSortedTreeAscHelper(node.getRightChild());
        }
    }

    // Returns a sorted list of the BinaryTree in descending order
    public List<Integer> getSortedTreeDesc() {
        getSortedTreeDescHelper(root);
        return sortedTreeDesc;
    }

    /**
     * Recursively add the right sub tree to the list
     * Add the root element
     * Recursively add the left sub tree
     *
     * @param node root node
     */
    private void getSortedTreeDescHelper(Node node) {
        if (node != null) {
            getSortedTreeDescHelper(node.getRightChild());
            sortedTreeDesc.add(node.getValue());
            getSortedTreeDescHelper(node.getLeftChild());
        }
    }


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

        root = new Node((Integer) elements[0]);

        int[] elementsToAdd = new int[elements.length - 1];

        for (int i = 1; i < elements.length; i++) {
            elementsToAdd[i - 1] = (Integer) elements[i];
        }

        addElements(elementsToAdd);

        getSortedTreeAsc().toArray(elements);
    }

    @Override
    public String toString() {
        return "BinaryTree Sorter";
    }

    /**
     * Inner class Node for BinaryTree
     */
    public class Node {

        private final int value;
        private Node leftChild, rightChild;

        Node(int value) {
            this.value = value;
            rightChild = null;
            leftChild = null;
        }

        int getValue() {
            return value;
        }

        Node getLeftChild() {
            return leftChild;
        }

        void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        Node getRightChild() {
            return rightChild;
        }

        void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        boolean isLeftChildEmpty() {
            return leftChild == null;
        }

        boolean isRightChildEmpty() {
            return rightChild == null;
        }
    }
}
