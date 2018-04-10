package com.m3c.md.controller;

import com.m3c.md.model.Constants;
import org.apache.log4j.PropertyConfigurator;

/**
 * Starter, beginning of the program execution
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class Starter {
    public static void main(String[] args) {
        SortManager sortManager = new SortManager();
        sortManager.sortArray();
        initialiseLogger();
    }

    private static void initialiseLogger() {
        PropertyConfigurator.configure(Constants.LOG_PROPERTIES_FILE);
    }
}