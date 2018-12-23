package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.buffer.IBuffer;
import it.sevenbits.courses.sm.containers.Container;
import it.sevenbits.courses.sm.network.NetworkPackage;

/**
 * add networkPackage in buffer
 */
public class Add implements INetworkManagerCommands {
    private IBuffer buffer;
    private NetworkPackage p;
    private Container container;

    /**
     * default constructor
     * @param container container
     */
    Add(final Container container) {
        this.container = container;
        this.buffer = container.getBuffer();
    }
    @Override
    public void execute() {
        this.p = container.getPackage();
        buffer.add(p);
    }
}
