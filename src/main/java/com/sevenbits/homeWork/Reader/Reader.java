package com.sevenbits.homeWork.Reader;

import java.io.IOException;

/**
 * reader class
 */
public class Reader implements IReader {
    private String text = null;
    private boolean next;
    private int position = 0;

    /**
     *
     * @param text init variable
     */
    public Reader(final String text) {
        this.text = text;
    }

    /**
     *
     * @return char
     */
    public boolean hasNext() {
        return position < text.length();
    }

    /**
     *
     * @return symbol text
     */
    public char getSimbol() {
        char buff = text.charAt(position);
        position++;
        return buff;
    }

    @Override
    public boolean theEnd() throws IOException {
        return !(position < text.length());
    }
}
