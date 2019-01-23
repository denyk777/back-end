package com.sevenbits.homeWork.tokens;

/**
 * token class
 */
public class Token implements IToken {
    private String name;
    private StringBuilder sb;

    /**
     * token default constructor
     */
    public Token() {
        this.sb = new StringBuilder();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLexeme() {
        return String.valueOf(sb);
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public void append(final char symbol) {
        this.sb.append(symbol);
    }
}
