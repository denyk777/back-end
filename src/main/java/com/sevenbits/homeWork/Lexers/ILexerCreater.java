package com.sevenbits.homeWork.Lexers;

import com.sevenbits.homeWork.Reader.IReader;

/**
 *
 */
public interface ILexerCreater {
    /**
     *
     * @param reader reader
     * @return ILexer
     */
    ILexer createLexer(IReader reader);
}
