package com.sevenbits.homeWork.tokens;

/**
 * token interface
 */
public interface IToken {
    /**
     *
     * @return token name
     */
    String getName();

    /**
     *
     * @return lexeme
     */
    String getLexeme();

    /**
     *
     * @param name set name lexeme
     */
    void setName(String name);

    /**
     *
     * @param symbol added symbol in end line
     */
    void append(char symbol);
}
