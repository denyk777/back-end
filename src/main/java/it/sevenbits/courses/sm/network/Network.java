package it.sevenbits.courses.sm.network;

import it.sevenbits.courses.sm.manager.sm.StateMachineNetworkManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * network class
 */
public class Network implements INetwork {
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();
    private Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);
    /**
     * default constructor
     * @param maxSize max size
     */
    public Network(final int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage() {
        logger.debug("return first package");
        return packages.removeFirst();
    }

    @Override
    public void addPackage(final String message, final String type) {
        if (packages.size() < maxSize) {
            logger.debug("package size < " + maxSize);
            packages.addLast(new NetworkPackage(type, message));
        }
        logger.error("package was not added");
    }
}
