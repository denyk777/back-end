package it.sevenbits.courses.sm.buffer;

import it.sevenbits.courses.sm.network.NetworkPackage;

/**
 * buffer interface
 */
public interface IBuffer {
    /**
     *
     * @param p networkPackage
     */
    void add(NetworkPackage p);

    /**
     * clear string
     */
    void clear();

    /**
     * write string in console
     */
    void outputBuffer();
}
