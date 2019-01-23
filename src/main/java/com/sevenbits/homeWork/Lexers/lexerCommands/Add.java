package com.sevenbits.homeWork.Lexers.lexerCommands;

import com.sevenbits.homeWork.tokens.Token;

/**
 * add char in string
 */
public class Add implements ICommandsManager {
    @Override
    public void excecute(final Token token, final char c) {
        token.append(c);
    }
}
