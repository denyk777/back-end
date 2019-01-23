package com.sevenbits.homeWork.Formatter.formatterCommands;

import com.sevenbits.homeWork.Writer.IWriter;
import com.sevenbits.homeWork.tokens.IToken;

/**
 * formater command manager
 */
public interface ICommandsManager {
    /**
     *
     * @param token token
     * @param level level
     * @param writer writer
     */
    void excecute(IToken token, int level, IWriter writer);
}
