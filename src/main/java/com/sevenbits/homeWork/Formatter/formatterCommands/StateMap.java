package com.sevenbits.homeWork.Formatter.formatterCommands;

import java.util.HashMap;
import java.util.Map;

/**
 * state map
 */
class StateMap {
    private final State defaultState = new State("IGNORE");
    private final Map<Pair<State, String>, State> states;

    /**
     * default constructor
     */
    StateMap() {
        states = new HashMap<>();
        State open = new State("OPEN");
        State word = new State("WORD");
        State comma = new State("COMMA");
        State closingBr = new State("CLOSING_BRACKET");
        State dotComma = new State("DOTCOMMA");
        State close = new State("CLOSE");
        State math = new State("MATH");
        State comment = new State("COMMENT");
        State endLine = new State("ENDLINE");

        states.put(new Pair<>(defaultState, "OPEN"), open);
        states.put(new Pair<>(defaultState, "WORD"), word);
        states.put(new Pair<>(defaultState, "CLOSING_BRACKET"), closingBr);

        states.put(new Pair<>(open, "WORD"), word);
        states.put(new Pair<>(open, "OPEN"), open);
        states.put(new Pair<>(open, "CLOSE"), close);
        states.put(new Pair<>(open, "COMMENT"), comment);


        states.put(new Pair<>(close, "WORD"), word);
        states.put(new Pair<>(close, "OPEN"), open);
        states.put(new Pair<>(close, "CLOSE"), close);
        states.put(new Pair<>(close, "COMMENT"), comment);

        states.put(new Pair<>(word, "OPEN"), open);
        states.put(new Pair<>(word, "WORD"), word);
        states.put(new Pair<>(word, "COMMA"), comma);
        states.put(new Pair<>(word, "CLOSING_BRACKET"), closingBr);
        states.put(new Pair<>(word, "DOTCOMMA"), dotComma);
        states.put(new Pair<>(word, "CLOSE"), close);
        states.put(new Pair<>(word, "MATH"), math);
        states.put(new Pair<>(word, "COMMENT"), comment);

        states.put(new Pair<>(comma, "WORD"), word);
        states.put(new Pair<>(comma, "COMMENT"), comment);

        states.put(new Pair<>(closingBr, "OPEN"), open);
        states.put(new Pair<>(closingBr, "DOTCOMMA"), dotComma);
        states.put(new Pair<>(closingBr, "WORD"), word);
        states.put(new Pair<>(closingBr, "CLOSING_BRACKET"), closingBr);
        states.put(new Pair<>(closingBr, "CLOSE"), close);
        states.put(new Pair<>(closingBr, "COMMENT"), comment);

        states.put(new Pair<>(dotComma, "WORD"), word);
        states.put(new Pair<>(dotComma, "OPEN"), open);
        states.put(new Pair<>(dotComma, "CLOSE"), close);
        states.put(new Pair<>(dotComma, "COMMENT"), comment);

        states.put(new Pair<>(math, "WORD"), word);
        states.put(new Pair<>(math, "MATH"), math);
        states.put(new Pair<>(math, "COMMENT"), comment);

        states.put(new Pair<>(comment, "ENDLINE"), endLine);
        states.put(new Pair<>(comment, "DOTCOMMA"), dotComma);
        states.put(new Pair<>(comment, "OPEN"), comment);
        states.put(new Pair<>(comment, "WORD"), comment);
        states.put(new Pair<>(comment, "CLOSE"), comment);

        states.put(new Pair<>(endLine, "OPEN"), open);
        states.put(new Pair<>(endLine, "WORD"), word);
        states.put(new Pair<>(endLine, "CLOSING_BRACKET"), closingBr);
    }

    State getStartState() {
        return defaultState;
    }

    /**
     *
     * @param state state
     * @param message message
     * @return new state
     */
    State getNextState(final State state, final String message) {
        return states.getOrDefault(new Pair<>(state, message), defaultState);
    }
}
