package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.network.NetworkPackage;

/**
 * state transition class
 */
public final class StateTransition {

    private final StateMap stateMap;

    /**
     * state transition constructor
     */
    public StateTransition() {
        this.stateMap = new StateMap();
    }

    /**
     *
     * @param state state
     * @param p network package
     * @return state
     */
    public State nextState(final State state, final NetworkPackage p) {
        return stateMap.getNextState(state, p.getType());
    }

    /**
     *
     * @return state
     */
    public State getStartState() {
        return this.stateMap.getStartState();
    }
}
