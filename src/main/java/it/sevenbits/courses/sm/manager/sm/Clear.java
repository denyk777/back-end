package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.buffer.IBuffer;
import it.sevenbits.courses.sm.containers.Container;

/**
 * clearing buffer string
 */
public class Clear implements INetworkManagerCommands {
    private IBuffer buffer;

    /**
     * default constructor
     * @param container container
     */
    Clear(final Container container) {
        this.buffer = container.getBuffer();
    }

    @Override
    public void execute() {
        buffer.outputBuffer();
        buffer.clear();
    }
}