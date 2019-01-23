package com.sevenbits.homeWork.Writer;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import java.io.IOException;

/**
 * writer class
 */
public class WriterForFile implements IWriter, AutoCloseable {
    private BufferedWriter bw;

    /**
     *
     * @param writer writer
     */
    public WriterForFile(final Writer writer) {
        bw = new BufferedWriter(writer);
    }

    /**
     *
     * @param outputStream output steam
     * @param charset encoding
     */
    public WriterForFile(final OutputStream outputStream, final Charset charset) {
        bw = new BufferedWriter(new OutputStreamWriter(outputStream, charset));
    }
    /**
     * @param symbol character
     * @throws IOException Exception
     */
    @Override
    public void write(final char symbol) throws IOException {
        bw.write((int) symbol);
    }

    @Override
    public void close() throws IOException {
        bw.close();
    }
}
