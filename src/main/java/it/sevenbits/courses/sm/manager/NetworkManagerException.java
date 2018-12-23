package it.sevenbits.courses.sm.manager;

/**
 * exception manager
 */
public class NetworkManagerException extends Exception {
    /**
     *
     * @param message message
     * @param cause cause
     */
    public NetworkManagerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param message message
     */
    public NetworkManagerException(final String message) {
        super(message);
    }
}
