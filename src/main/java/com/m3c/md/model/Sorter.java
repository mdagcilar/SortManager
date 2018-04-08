package com.m3c.md.model;

public interface Sorter {

    <T extends Comparable<T>> void sort(T[] t);
}