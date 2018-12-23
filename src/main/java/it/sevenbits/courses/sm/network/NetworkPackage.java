package it.sevenbits.courses.sm.network;

/**
 * network package
 */
public class NetworkPackage {
    private String type;

    private String message;

    /**
     *
     * @param type type
     * @param message message
     */
    public NetworkPackage(final String type, final String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
