package com.sevenbits.homeWork.Writer;

import java.io.IOException;

/**
 * writer interface
 */
public interface IWriter {
    /**
     *
     * @param simb put to out
     * @throws IOException write exception
     */
    void write(char simb) throws IOException;
}
