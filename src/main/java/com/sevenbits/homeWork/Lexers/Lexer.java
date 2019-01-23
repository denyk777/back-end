package com.sevenbits.homeWork.Lexers;

import com.sevenbits.homeWork.Lexers.lexerCommands.CommandNameLexem;
import com.sevenbits.homeWork.Lexers.lexerCommands.CommandsRepository;
import com.sevenbits.homeWork.Lexers.lexerCommands.ICommandLexer;
import com.sevenbits.homeWork.Lexers.lexerCommands.ICommandsManager;
import com.sevenbits.homeWork.Reader.IReader;
import com.sevenbits.homeWork.tokens.IToken;
import com.sevenbits.homeWork.tokens.Token;

import java.io.IOException;

/**
 * find lexeme in line
 */
public class Lexer implements ILexer {
    private CommandsRepository commandsReader = new CommandsRepository();
    private CommandNameLexem lexem = new CommandNameLexem();
    private IReader reader;
    private boolean hasMore = false;
    private int more = 0;
    private static final int ITERATION = 1000;
    /**
     *
     * @param reader provide char string
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
    }

    @Override
    public IToken readToken() throws IOException {
        Token token = new Token();
        boolean space = false;
        boolean startSpase = true;
        while (reader.hasNext() && !space) {
            char c = reader.getSimbol();
            while (startSpase) {
                if (c == ' ') {
                    c = reader.getSimbol();
                } else {
                    startSpase = false;
                }
            }
            ICommandsManager manager = commandsReader.getCommand(c);
            manager.excecute(token, c);
            if (c == ' ') {
                space = true;
            }
        }
        ICommandLexer lexer = lexem.getCommand(token.getLexeme());
        lexer.excecute(token);
        more++;
        if (more > ITERATION) {
            hasMore = true;
        }
        return token;
    }

    @Override
    public boolean hasMoreTokens() {
        return !hasMore;
    }
}
