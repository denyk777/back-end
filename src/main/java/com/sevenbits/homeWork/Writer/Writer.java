package com.sevenbits.homeWork.Writer;

import java.io.IOException;

/**
 * writer class
 */
public class Writer implements IWriter {
    private StringBuilder stringBuilder;

    /**
     *
     * @param stringBuilder init sb
     */
    public Writer(final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    /**
     *
     * @param simb write to console
     * @throws IOException exception
     */
    public void write(final char simb) throws IOException {
        stringBuilder.append(simb);
    }
}
