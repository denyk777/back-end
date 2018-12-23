package it.sevenbits.courses.sm.manager.sm;

import java.util.HashMap;
import java.util.Map;

/**
 * state map class
 */
class StateMap {
    private final State defaultState = new State("IGNORE");

    private final Map<Pair<State, String>, State> states;

    /**
     * default state map constructor
     */
    StateMap() {
        states = new HashMap<>();
        State listenState = new State("LISTEN");
        State stubSuspicion = new State("TRASH_SUSPICION");

        states.put(new Pair<>(defaultState, "MESSAGE_START"), listenState);
        states.put(new Pair<>(defaultState, "MESSAGE"), defaultState);
        states.put(new Pair<>(defaultState, "TRASH"), defaultState);

        states.put(new Pair<>(listenState, "MESSAGE"), listenState);
        states.put(new Pair<>(listenState, "TRASH"), stubSuspicion);
        states.put(new Pair<>(listenState, "MESSAGE_FINISH"), defaultState);

        states.put(new Pair<>(stubSuspicion, "MESSAGE"), stubSuspicion);
        states.put(new Pair<>(stubSuspicion, "TRASH"), defaultState);
        states.put(new Pair<>(stubSuspicion, "MESSAGE_FINISH"), defaultState);
    }

    /**
     *
     * @return state
     */
    public State getStartState() {
        return defaultState;
    }

    /**
     *
     * @param state state
     * @param signal signal
     * @return state
     */
    public State getNextState(final State state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), defaultState);
    }
}
