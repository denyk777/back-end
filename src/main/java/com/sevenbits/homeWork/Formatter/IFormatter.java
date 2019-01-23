package com.sevenbits.homeWork.Formatter;

import com.sevenbits.homeWork.Lexers.ILexer;
import com.sevenbits.homeWork.Writer.IWriter;

import java.io.IOException;

/**
 * formatter interface
 */
public interface IFormatter {
    /**
     * @param lexer lexer
     * @param writer string
     * @throws IOException write exception
     */
    void format(ILexer lexer, IWriter writer) throws IOException;
}
