package com.m3c.md.controller;

import com.m3c.md.sorters.BubbleSort;
import com.m3c.md.sorters.MergeSort;
import com.m3c.md.sorters.QuickSort;
import com.m3c.md.sorters.Sorter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SortFactory {

    public static Sorter getInstance() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("resources/factory.properties"));

            String sorter = properties.getProperty("sorter");

            switch (sorter) {
                case "bubble":
                    return new BubbleSort();
                case "merge":
                    return new MergeSort();
                case "quick":
                    return new QuickSort();
                default:
                    //TODO: throw new exception
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}