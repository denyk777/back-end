package com.sevenbits.homeWork.Reader;

import java.io.IOException;

/**
 * reader interface
 */
public interface IReader {
    /**
     *
     * @return boolean
     * @throws IOException write exception
     */
    boolean hasNext() throws IOException;

    /**
     *
     * @return char
     * @throws IOException write exception
     */
    char getSimbol() throws IOException;

    /**
     *
     * @return end file
     * @throws IOException exception
     */
    boolean theEnd() throws IOException;
}
