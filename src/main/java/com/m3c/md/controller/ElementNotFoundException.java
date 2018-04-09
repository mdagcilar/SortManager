package com.m3c.md.controller;

/**
 * ElementNotFoundException
 *
 * @author Metin Dagcilar
 * @version 1.0
 * @since 2018-04-03
 */

public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(String message) {
        super(message);
    }

    public ElementNotFoundException() {
        super();
    }
}
