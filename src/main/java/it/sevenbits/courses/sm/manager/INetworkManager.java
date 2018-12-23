package it.sevenbits.courses.sm.manager;

import it.sevenbits.courses.sm.network.INetwork;

/**
 * manager network interface
 */
public interface INetworkManager {
    /**
     *
     * @param network network
     * @throws NetworkManagerException exception
     */
    void listen(INetwork network) throws NetworkManagerException;

    /**
     * stop generation
     */
    void stop();
}
