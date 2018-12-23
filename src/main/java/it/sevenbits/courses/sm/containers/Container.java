package it.sevenbits.courses.sm.containers;

import it.sevenbits.courses.sm.buffer.IBuffer;
import it.sevenbits.courses.sm.manager.sm.State;
import it.sevenbits.courses.sm.network.NetworkPackage;

/**
 * containing buffer string
 */
public class Container {
    private State currentState;
    private NetworkPackage networkPackage;
    private IBuffer buffer;

    public IBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(final IBuffer buffer) {
        this.buffer = buffer;
    }

    public State getCurrentState() {
        return currentState;
    }

    public NetworkPackage getPackage() {
        return networkPackage;
    }

    public void setState(final State state) {
        currentState = state;
    }

    public void setPackage(final NetworkPackage p) {
        this.networkPackage = p;
    }

}
