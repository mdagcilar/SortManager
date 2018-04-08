package com.m3c.md.model;

/**
 * Sorter interface
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public interface Sorter {

    <T extends Comparable<T>> void sort(T[] t);
}