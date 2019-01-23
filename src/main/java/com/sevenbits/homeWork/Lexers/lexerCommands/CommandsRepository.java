package com.sevenbits.homeWork.Lexers.lexerCommands;

import java.util.HashMap;
import java.util.Map;

/**
 * alphabet
 */
public class CommandsRepository {
    private Map<Character, ICommandsManager> commands;

    /**
     * default constructor
     */
    public CommandsRepository() {
        commands = new HashMap<>();
        commands.put(' ', new Pass());
        commands.put('\n', new Pass());

        commands.put('a', new Add());
        commands.put('b', new Add());
        commands.put('c', new Add());
        commands.put('d', new Add());
        commands.put('e', new Add());
        commands.put('f', new Add());
        commands.put('g', new Add());
        commands.put('h', new Add());
        commands.put('i', new Add());
        commands.put('j', new Add());
        commands.put('k', new Add());
        commands.put('l', new Add());
        commands.put('m', new Add());
        commands.put('n', new Add());
        commands.put('o', new Add());
        commands.put('p', new Add());
        commands.put('q', new Add());
        commands.put('r', new Add());
        commands.put('s', new Add());
        commands.put('t', new Add());
        commands.put('u', new Add());
        commands.put('v', new Add());
        commands.put('w', new Add());
        commands.put('x', new Add());
        commands.put('y', new Add());
        commands.put('z', new Add());
        commands.put('A', new Add());
        commands.put('B', new Add());
        commands.put('C', new Add());
        commands.put('D', new Add());
        commands.put('E', new Add());
        commands.put('F', new Add());
        commands.put('G', new Add());
        commands.put('H', new Add());
        commands.put('I', new Add());
        commands.put('J', new Add());
        commands.put('K', new Add());
        commands.put('L', new Add());
        commands.put('M', new Add());
        commands.put('N', new Add());
        commands.put('O', new Add());
        commands.put('P', new Add());
        commands.put('Q', new Add());
        commands.put('R', new Add());
        commands.put('S', new Add());
        commands.put('T', new Add());
        commands.put('U', new Add());
        commands.put('V', new Add());
        commands.put('W', new Add());
        commands.put('X', new Add());
        commands.put('Y', new Add());
        commands.put('Z', new Add());

        commands.put('+', new Add());
        commands.put('-', new Add());
        commands.put('*', new Add());
        commands.put('/', new Add());
        commands.put('=', new Add());

        commands.put('(', new Add());
        commands.put(')', new Add());
        commands.put('{', new Add());
        commands.put('}', new Add());
        commands.put(';', new Add());

        commands.put(',', new Add());
        commands.put('.', new Add());
    }

    /**
     *
     * @param character char
     * @return command
     */
    public ICommandsManager getCommand(final char character) {
        return commands.getOrDefault(character, new Pass());
    }
}
