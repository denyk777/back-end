package com.sevenbits.homeWork.Formatter.formatterCommands;

import com.sevenbits.homeWork.Formatter.formatterCommands.commandsFolder.OpBracketOpBracket;
import com.sevenbits.homeWork.Formatter.formatterCommands.commandsFolder.WordOpBracked;
import com.sevenbits.homeWork.Formatter.formatterCommands.commandsFolder.WordWrod;

import java.util.HashMap;
import java.util.Map;

/**
 * manager commands class
 */
public class CommandManager {

    private final Map<Pair<String, String>, ICommandsManager> commands;

    /**
     * default constructor
     */
    public CommandManager() {
        commands = new HashMap<>();
        commands.put(new Pair<>("WORD", "OPEN"), new WordOpBracked());

        commands.put(new Pair<>("WORD", "WORD"), new WordWrod());
        commands.put(new Pair<>("WORD", "DOTCOMMA"), new OpBracketOpBracket());
        commands.put(new Pair<>("WORD", "MATH"), new WordWrod());
        commands.put(new Pair<>("WORD", "COMMENT"), new Write());

        commands.put(new Pair<>("OPEN", "OPEN"), new OpBracketOpBracket());
        commands.put(new Pair<>("OPEN", "CLOSE"), new OpBracketOpBracket());
        commands.put(new Pair<>("OPEN", "COMMENT"), new Write());

        commands.put(new Pair<>("CLOSE", "CLOSE"), new OpBracketOpBracket());
        commands.put(new Pair<>("CLOSE", "COMMENT"), new Write());

        commands.put(new Pair<>("COMMA", "WORD"), new WordWrod());
        commands.put(new Pair<>("COMMA", "COMMENT"), new Write());

        commands.put(new Pair<>("CLOSING_BRACKET", "OPEN"), new WordOpBracked());
        commands.put(new Pair<>("CLOSING_BRACKET", "DOTCOMMA"), new OpBracketOpBracket());
        commands.put(new Pair<>("CLOSING_BRACKET", "COMMENT"), new Write());

        commands.put(new Pair<>("DOTCOMMA", "CLOSE"), new OpBracketOpBracket());
        commands.put(new Pair<>("DOTCOMMA", "OPEN"), new OpBracketOpBracket());
        commands.put(new Pair<>("DOTCOMMA", "COMMENT"), new Write());

        commands.put(new Pair<>("MATH", "WORD"), new WordWrod());
        commands.put(new Pair<>("MATH", "MATH"), new Write());
        commands.put(new Pair<>("MATH", "COMMENT"), new Write());

        commands.put(new Pair<>("COMMENT", "COMMENT"), new WordWrod());
        commands.put(new Pair<>("COMMENT", "WORD"), new WordWrod());
        commands.put(new Pair<>("COMMENT", "OPEN"), new WordWrod());
        commands.put(new Pair<>("COMMENT", "CLOSE"), new WordWrod());
        commands.put(new Pair<>("COMMENT", "DOTCOMMA"), new OpBracketOpBracket());
    }

    /**
     *
     * @param name name
     * @param lexem lexem
     * @return command
     */
    public ICommandsManager getCommand(final State name, final String lexem) {
        return commands.getOrDefault(new Pair<>(name.toString(), lexem), new Write());
    }
}
