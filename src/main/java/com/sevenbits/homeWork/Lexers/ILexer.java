package com.sevenbits.homeWork.Lexers;


import com.sevenbits.homeWork.tokens.IToken;

import java.io.IOException;

/**
 *
 */
public interface ILexer {
    /**
     *
     * @return IToken
     * @throws IOException exception
     */
    IToken readToken() throws IOException;

    /**
     *
     * @return boolean
     */
    boolean hasMoreTokens();
}
