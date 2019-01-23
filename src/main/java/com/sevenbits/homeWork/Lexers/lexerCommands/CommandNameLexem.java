package com.sevenbits.homeWork.Lexers.lexerCommands;

import java.util.HashMap;
import java.util.Map;

/**
 * list name lexem
 */
public class CommandNameLexem {
    private Map<String, ICommandLexer> commands;

    /**
     * default constructor
     */
    public CommandNameLexem() {
        commands = new HashMap<>();

        commands.put("(", new AddLexem("OPENING_BRACKET"));
        commands.put(")", new AddLexem("CLOSING_BRACKET"));
        commands.put("{", new AddLexem("OPEN"));
        commands.put("}", new AddLexem("CLOSE"));

        commands.put(".", new AddLexem("Dot"));
        commands.put(",", new AddLexem("COMMA"));

        commands.put("+", new AddLexem("MATH"));
        commands.put("-", new AddLexem("MATH"));
        commands.put("*", new AddLexem("MATH"));
        commands.put("/", new AddLexem("MATH"));
        commands.put("=", new AddLexem("MATH"));

        commands.put("\n", new AddLexem("ENDLINE"));
        commands.put(";", new AddLexem("DOTCOMMA"));

        commands.put("//", new AddLexem("COMMENT"));
    }

    /**
     *
     * @param name string for comparator
     * @return lexem name
     */
    public ICommandLexer getCommand(final String name) {
        return commands.getOrDefault(name, new AddLexem("WORD"));
    }
}
