package it.sevenbits.courses.sm.buffer;

import it.sevenbits.courses.sm.network.NetworkPackage;

/**
 * controlling buffer string
 */
public class Buffer implements IBuffer {
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void add(final NetworkPackage p) {
        buffer.append(p.getMessage());
    }

    @Override
    public void clear() {
        buffer.setLength(0);
    }

    @Override
    public void outputBuffer() {
        System.out.println(buffer.toString() + '\n');
    }
}
