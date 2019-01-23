package com.sevenbits.homeWork.Formatter;

import com.sevenbits.homeWork.Formatter.formatterCommands.CommandManager;
import com.sevenbits.homeWork.Formatter.formatterCommands.ICommandsManager;
import com.sevenbits.homeWork.Formatter.formatterCommands.State;
import com.sevenbits.homeWork.Formatter.formatterCommands.StateTransition;
import com.sevenbits.homeWork.Lexers.ILexer;
import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.tokens.IToken;

import java.io.IOException;

/**
 * formatter class
 */
public class Formatter implements IFormatter {
    /**
     * contain command
     */
    private CommandManager commandsFormater = new CommandManager();
    /**
     * contain state
     */
    private State state = null;
    private static final int TAB = 4;
    private int level = 0;
    private StateTransition stateTransition;

    /**
     * constructor whits initialize
     */
    public Formatter() {
        this.stateTransition = new StateTransition();
    }

    /**
     * @param lexer contain lexer
     * @param writer put string to out
     * @throws IOException write exception
     */
    public void format(final ILexer lexer, final IWriter writer) throws IOException {
        State state = stateTransition.getStartState();

        while (lexer.hasMoreTokens()) {
            IToken token = lexer.readToken();
            calcLevel(token.getName(), state.toString(), writer);
            ICommandsManager manager = commandsFormater.getCommand(state, token.getName());
            manager.excecute(token, level, writer);
            state = stateTransition.nextState(state, token);
        }
    }

    private void writeSpace(final IWriter writer) {
        for (int i = 0; i < (this.level * TAB); i++) {
            try {
                writer.write(' ');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param token name
     * @param stateName name
     * @param writer writer
     */
    private void calcLevel(final String token, final String stateName, final IWriter writer) {
        if (stateName.equals("OPEN") && token.equals("WORD")) {
            this.level++;
            writeSpace(writer);
        } else if (stateName.equals("DOTCOMMA") && token.equals("CLOSE")) {
            this.level--;
            writeSpace(writer);
        } else if (stateName.equals("DOTCOMMA") && token.equals("OPEN")) {
            writeSpace(writer);
        } else if (stateName.equals("OPEN") && token.equals("OPEN")) {
            this.level++;
            writeSpace(writer);
        } else if (stateName.equals("DOTCOMMA") && token.equals("WORD")) {
            writeSpace(writer);
        } else if (stateName.equals("CLOSE") && token.equals("CLOSE")) {
            this.level--;
            writeSpace(writer);
        } else if (stateName.equals("CLOSE") && token.equals("WORD")) {
            writeSpace(writer);
        }
    }
}