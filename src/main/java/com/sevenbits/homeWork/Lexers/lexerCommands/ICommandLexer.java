package com.sevenbits.homeWork.Lexers.lexerCommands;

import com.sevenbits.homeWork.tokens.Token;

/**
 * lexer interface
 */
public interface ICommandLexer {
    /**
     *
     * @param token token
     */
    void excecute(Token token);
}
