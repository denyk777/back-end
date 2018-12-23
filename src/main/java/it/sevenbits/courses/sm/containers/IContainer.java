package it.sevenbits.courses.sm.containers;

import it.sevenbits.courses.sm.buffer.IBuffer;
import it.sevenbits.courses.sm.manager.sm.State;
import it.sevenbits.courses.sm.network.NetworkPackage;

/**
 * container interface
 */
public interface IContainer {
    /**
     * @param buffer buffer
     * @param state state
     */
    void set(IBuffer buffer, State state);

    /**
     * @return state
     */
    State getState();

    /**
     *
     * @return networkPackage
     */
    NetworkPackage getNetworkPackage();

    /**
     *
     * @param p networkPackage
     */
    void setPack(NetworkPackage p);
}
