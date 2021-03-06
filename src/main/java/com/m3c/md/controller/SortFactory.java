package com.m3c.md.controller;

import com.m3c.md.model.Constants;
import com.m3c.md.model.sorters.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * SortFactory
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class SortFactory {

    public static Sorter getInstance() throws SortManagerException {
        try (FileReader fr = new FileReader(Constants.FACTORY_PROPERTIES_FILE)) {

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
                    return new BinaryTreeSorter();
                default:
                    throw new SortManagerException(Constants.TYPE_NOT_FOUND);
            }
        } catch (IOException e) {
            throw new SortManagerException(Constants.CONFIG_ERROR);
        }
    }
}