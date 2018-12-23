package it.sevenbits.courses.sm.network;

/**
 * INetwork interface
 */
public interface INetwork {
    /**
     *
     * @return package exist
     */
    boolean hasPackage();

    /**
     *
     * @return networkPackage
     */
    NetworkPackage getPackage();

    /**
     *
     * @param message message
     * @param type type
     */
    void addPackage(String message, String type);
}
