package com.sevenbits.homeWork.Formatter.formatterCommands;

import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.tokens.IToken;

import java.io.IOException;

/**
 * added one space
 */
public class AddOneSpace implements ICommandsManager {
    @Override
    public void excecute(final IToken token, final int level, final IWriter writer) {
        try {
            writer.write(' ');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
