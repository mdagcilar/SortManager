package com.m3c.md.sorters;

public interface Sorter {

    <T extends Comparable<T>> void sort(T[] t);
}