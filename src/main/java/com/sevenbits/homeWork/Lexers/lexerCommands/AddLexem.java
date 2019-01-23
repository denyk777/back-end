package com.sevenbits.homeWork.Lexers.lexerCommands;

import com.sevenbits.homeWork.tokens.Token;

/**
 * add lexem
 */
public class AddLexem implements ICommandLexer {
    /**
     * name
     */
    private String name;

    /**
     *
     * @param name lexem
     */
    AddLexem(final String name) {
        this.name = name;
    }

    @Override
    public void excecute(final Token token) {
        token.setName(name);
    }
}
