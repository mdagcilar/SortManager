package com.m3c.md.controller;

import com.m3c.md.model.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Author: Metin Dagcilar
 * Date: 06/04/18
 * Description: SortFactory
 */

public class SortFactory {

    private static final String TYPE_NOT_FOUND = "Sorry - this sorter type is not available";
    private static final String CONFIG_ERROR = "Sorry - Configuration file not found";

    public static Sorter getInstance() throws SortManagerException {
        try (FileReader fr = new FileReader("resources/factory.properties")) {

            Properties properties = new Properties();
            properties.load(fr);

            String sorter = properties.getProperty("sorter");

            switch (sorter) {
                case "bubble":
                    return new BubbleSort();
                case "merge":
                    return new MergeSort();
                case "quick":
                    return new QuickSort();
                case "binarytree":
                    return new BinaryTreeImpl();
                default:
                    throw new SortManagerException(TYPE_NOT_FOUND);
            }
        } catch (IOException e) {
            throw new SortManagerException(CONFIG_ERROR);
        }
    }
}