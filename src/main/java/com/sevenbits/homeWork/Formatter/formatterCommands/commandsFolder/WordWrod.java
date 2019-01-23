package com.sevenbits.homeWork.Formatter.formatterCommands.commandsFolder;

import com.sevenbits.homeWork.Formatter.formatterCommands.AddOneSpace;
import com.sevenbits.homeWork.Formatter.formatterCommands.ICommandsManager;
import com.sevenbits.homeWork.Formatter.formatterCommands.Write;
import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.tokens.IToken;

/**
 * space between word and word
 */
public class WordWrod implements ICommandsManager {
    @Override
    public void excecute(final IToken token, final int level, final IWriter writer) {
        AddOneSpace addOneSpace = new AddOneSpace();
        Write write = new Write();
        addOneSpace.excecute(token, level, writer);
        write.excecute(token, level, writer);
    }
}
