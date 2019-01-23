package com.sevenbits.homeWork.Lexers.lexerCommands;

import com.sevenbits.homeWork.tokens.Token;

/**
 * lexer command manager interface
 */
public interface ICommandsManager {
    /**
     *
     * @param token token
     * @param c char
     */
    void excecute(Token token, char c);
}
