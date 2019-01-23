package com.sevenbits.homeWork.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * read file class
 */
public class ReaderForFile implements IReader, AutoCloseable {
    private BufferedReader br;
    private int symbol = 0;

    /**
     *
     * @param reader reader
     */
    public ReaderForFile(final Reader reader) {
        br = new BufferedReader(reader);
    }

    /**
     *
     * @param inputStream input steam
     * @param charset encoding
     */
    public ReaderForFile(final InputStream inputStream, final Charset charset) {
        br = new BufferedReader(new InputStreamReader(inputStream, charset));
    }
    /**
     * @return boolean
     * @throws IOException Exception
     */
    public boolean hasNext() throws IOException {
        return br.ready();
    }

    /**
     * @return char
     * @throws IOException Exception
     */
    public char getSimbol() throws IOException {
        symbol =  br.read();
        return (char) symbol;
    }

    /**
     *
     * @throws Exception exception
     */
    public void close() throws Exception {
        br.close();
    }
}
