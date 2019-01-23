package com.sevenbits.homeWork;

import com.sevenbits.homeWork.Formatter.Formatter;
import com.sevenbits.homeWork.Lexers.ILexer;
import com.sevenbits.homeWork.Lexers.Lexer;
import com.sevenbits.homeWork.Reader.ReaderForFile;
import com.sevenbits.homeWork.Writer.WriterForFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/**
 * Main class
 */
final class Main {
    private Main(){}

    /**
     *
     * @param args provide argument
     * @throws Exception if file not found
     */
    public static void main(final String[] args) throws Exception {
        try (
                ReaderForFile readerForFile = new ReaderForFile(new FileInputStream(args[0]), Charset.forName("utf-8"));
                WriterForFile writerForFile = new WriterForFile(new FileOutputStream(args[1]), Charset.forName("utf-8"));
        ) {
            ILexer lexer = new Lexer(readerForFile);
            Formatter formatter = new Formatter();
            formatter.format(lexer, writerForFile);
        } catch (Exception e) {
            try (
                    ReaderForFile readerForFile = new ReaderForFile(new FileInputStream("in.txt"), Charset.forName("utf-8"));
                    WriterForFile writerForFile = new WriterForFile(new FileOutputStream("out.txt"), Charset.forName("utf-8"));
            ) {
                ILexer lexer = new Lexer(readerForFile);
                Formatter formatter = new Formatter();
                formatter.format(lexer, writerForFile);
            }
        }
    }
}
