package com.sevenbits.homeWork.Formatter.formatterCommands;

import java.util.Objects;

/**
 * state class
 */
public class State {
    private final String state;

    /**
     *
     * @param state state
     */
    State(final String state) {
        this.state = state;
    }

    /**
     *
     * @return state name
     */
    public String toString() {
        return state;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State itState = (State) o;
        return Objects.equals(itState, itState.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
