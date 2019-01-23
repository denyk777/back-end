package com.sevenbits.homeWork;

import com.sevenbits.homeWork.Formatter.Formatter;
import com.sevenbits.homeWork.Lexers.ILexer;
import com.sevenbits.homeWork.Lexers.Lexer;
import com.sevenbits.homeWork.Reader.IReader;
import com.sevenbits.homeWork.Reader.Reader;
import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.Writer.Writer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.fail;

public class FormatterTest {
    private Formatter formatter;

    @Before
    public void setUp() {
        this.formatter = new Formatter();
    }

    @Test
    public void currentResultOne() {
        StringBuilder current = new StringBuilder();
        String text = "void {{{qwe;asd;{zxc;}}}}";
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
                "}";
        ILexer reader = new Lexer(new Reader(text));
        IWriter writer = new Writer(current);
        try {
            formatter.format(reader, writer);
        } catch (IOException e) {
            fail("Error IO");
        }
        Assert.assertEquals(currentText, current.toString());
    }

    @Test
    public void currentResultTwo() {
        StringBuilder current = new StringBuilder();
        String text = "{{{q\nw\ne;{asd;}}}}";
        String currentText = "" +
                "{\n" +
                "    {\n" +
                "        {\n" +
                "            qwe;\n" +
                "            {\n" +
                "                asd;\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        ILexer reader = new Lexer(new Reader(text));
        IWriter writer = new Writer(current);
        try {
            formatter.format(reader, writer);
        } catch (IOException e) {
            fail("Error IO");
        }
        Assert.assertEquals(currentText, current.toString());
    }

    @Test
    public void currentResultThree() {
        StringBuilder current = new StringBuilder();
        String text = "void {qwe;for() {asd;}}";
        String currentText = "" +
                "void {\n" +
                "    qwe;\n" +
                "    for() {\n" +
                "        asd;\n" +
                "    }\n" +
                "}";
        ILexer reader = new Lexer(new Reader(text));
        IWriter writer = new Writer(current);
        try {
            formatter.format(reader, writer);
        } catch (IOException e) {
            fail("Error IO");
        }
        Assert.assertEquals(currentText, current.toString());
    }
}
