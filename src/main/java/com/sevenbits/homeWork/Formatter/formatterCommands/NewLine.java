package com.sevenbits.homeWork.Formatter.formatterCommands;

import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.tokens.IToken;

import java.io.IOException;

/**
 * class write new line
 */
public class NewLine implements ICommandsManager {
    @Override
    public void excecute(final IToken token, final int level, final IWriter writer) {
        try {
        writer.write('\n');
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
