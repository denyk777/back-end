package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.buffer.IBuffer;
import it.sevenbits.courses.sm.containers.Container;
import it.sevenbits.courses.sm.manager.sm.INetworkManagerCommands;

/**
 * output class
 */
public class Writer implements INetworkManagerCommands {
    private IBuffer buffer;

    /**
     *
     * @param container container
     */
    Writer(final Container container) {
        this.buffer = container.getBuffer();
    }

    @Override
    public void execute() {
        buffer.outputBuffer();
    }
}