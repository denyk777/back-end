package com.sevenbits.homeWork.Lexers;

import com.sevenbits.homeWork.Reader.IReader;

/**
 * return the lexer class
 */
public class LexerCreater implements ILexerCreater {
    @Override
    public ILexer createLexer(final IReader reader) {
        return new Lexer(reader);
    }
}
