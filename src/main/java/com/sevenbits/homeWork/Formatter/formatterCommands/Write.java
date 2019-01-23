package com.sevenbits.homeWork.Formatter.formatterCommands;

import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.tokens.IToken;

import java.io.IOException;

/**
 * write
 */
public class Write implements ICommandsManager {
    @Override
    public void excecute(final IToken token, final int level, final IWriter writer) {
        try {
            for (int i = 0; i < token.getLexeme().length(); i++) {
                writer.write(token.getLexeme().charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
