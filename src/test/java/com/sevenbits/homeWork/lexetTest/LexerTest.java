package com.sevenbits.homeWork.lexetTest;

import com.sevenbits.homeWork.Lexers.Lexer;
import com.sevenbits.homeWork.Reader.IReader;
import com.sevenbits.homeWork.tokens.IToken;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LexerTest {
    private IToken token;
    private Lexer lexer;
    private IReader reader;

    @Before
    public void setUp() {
        reader = mock(IReader.class);
        this.token = mock(IToken.class);
        lexer = new Lexer(reader);
    }

    @Test(expected = NullPointerException.class)
    public void failNullPointerTest() {
        try {
            when(reader.hasNext()).thenReturn(true);
            when(reader.getSimbol()).thenReturn('_');
            lexer.readToken();
        } catch (IOException e) {
            fail("IOException");
        }
    }

    @Test
    public void returnTokenNameMathTest() {
        try {
            String trueCurrent = "math";
            when(reader.hasNext()).thenReturn(true).thenReturn(false);
            when(reader.getSimbol()).thenReturn('+');
            token = lexer.readToken();
            Assert.assertEquals(trueCurrent, token.getName());
        } catch (IOException e) {
            fail("IOException");
        }
    }

}
