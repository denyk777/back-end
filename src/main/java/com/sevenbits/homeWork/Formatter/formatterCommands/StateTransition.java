package com.sevenbits.homeWork.Formatter.formatterCommands;

import com.sevenbits.homeWork.tokens.IToken;

/**
 * state transition
 */
public class StateTransition {
    private final StateMap stateMap;

    /**
     * default constructor
     */
    public StateTransition() {
        this.stateMap = new StateMap();
    }

    /**
     *
     * @param state state
     * @param token token
     * @return new state
     */
    public State nextState(final State state, final IToken token) {
        return stateMap.getNextState(state, token.getName());
    }

    public State getStartState() {
        return this.stateMap.getStartState();
    }
}
