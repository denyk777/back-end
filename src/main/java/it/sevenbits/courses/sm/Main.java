package it.sevenbits.courses.sm;

import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.sm.StateMachineNetworkManager;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.Network;

/**
 * main class
 */
public final class Main {

    private Main() {
    }

    /**
     * @param args args
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {
//        final INetworkManager nm = new SimpleNetworkManager();
        final INetworkManager nm = new StateMachineNetworkManager();
        final INetwork network = new Network(500);

        PackagesGenerator packagesGenerator = new PackagesGenerator();
        //Thread createMessagesThread = packagesGenerator.packagesFillerTaskOne(nm,network);
        Thread createMessagesThread = packagesGenerator.packagesFillerTaskTwo(nm, network);
        createMessagesThread.start();
        nm.listen(network);
    }
}
