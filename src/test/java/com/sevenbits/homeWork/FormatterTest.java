package com.sevenbits.homeWork;

import com.sevenbits.homeWork.Formatter.Formatter;
import com.sevenbits.homeWork.Lexers.ILexer;
import com.sevenbits.homeWork.Lexers.Lexer;
import com.sevenbits.homeWork.Reader.IReader;
import com.sevenbits.homeWork.Reader.Reader;
import com.sevenbits.homeWork.Reader.ReaderForFile;
import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.Writer.Writer;
import com.sevenbits.homeWork.Writer.WriterForFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

import static junit.framework.TestCase.fail;

public class FormatterTest {
    private Formatter formatter;

    @Before
    public void setUp() {
        this.formatter = new Formatter();
    }

    @Test
    public void currentResultOne() {
        try (
                ReaderForFile readerForFile = new ReaderForFile(new FileInputStream("test1.txt"), Charset.forName("utf-8"));
                WriterForFile writerForFile = new WriterForFile(new FileOutputStream("ans1.txt"), Charset.forName("utf-8"));
        ) {
            ILexer lexer = new Lexer(readerForFile);
            formatter.format(lexer, writerForFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder current = new StringBuilder();
        BufferedInputStream bufferedInputStream = null;
        int bytesRead = 0;
        byte[] buffer = new byte[1024];
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("ans1.txt"));
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                current.append(new String(buffer, 0 , bytesRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String currentText = "void {\n" +
                "    {\n" +
                "        {\n" +
                "            qwe;\n" +
                "            asd;\n" +
                "            {\n" +
                "                zxc;\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n";
        Assert.assertEquals(currentText, current.toString());
    }

    @Test
    public void currentResultTwo() {
        StringBuilder current = new StringBuilder();
        String text = "void { { { qwe ; asd ; { zxc ; } } } }";
        String currentText = "void {\n" +
                "    {\n" +
                "        {\n" +
                "            qwe;\n" +
                "            asd;\n" +
                "            {\n" +
                "                zxc;\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n";
        IReader reader = new Reader(text);
        ILexer lexer = new Lexer(reader);
        IWriter writer = new Writer(current);
        try {
            formatter.format(lexer, writer);
        } catch (IOException e) {
            fail("Error IO");
        }
        Assert.assertEquals(currentText, current.toString());
    }
}
