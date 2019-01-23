package com.sevenbits.homeWork.Formatter.formatterCommands.commandsFolder;

import com.sevenbits.homeWork.Formatter.formatterCommands.ICommandsManager;
import com.sevenbits.homeWork.Formatter.formatterCommands.NewLine;
import com.sevenbits.homeWork.Formatter.formatterCommands.Write;
import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.tokens.IToken;

/**
 * class write space between two bracket
 */
public class OpBracketOpBracket implements ICommandsManager {
    @Override
    public void excecute(final IToken token, final int level, final IWriter writer) {
        Write write = new Write();
        NewLine newLine = new NewLine();
        write.excecute(token, level, writer);
        newLine.excecute(token, level, writer);
    }
}
