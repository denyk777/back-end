package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.buffer.Buffer;
import it.sevenbits.courses.sm.buffer.IBuffer;
import it.sevenbits.courses.sm.containers.Container;
import it.sevenbits.courses.sm.log.MessageFormatter;
import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.NetworkManagerException;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.NetworkPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * state machine class
 */
public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private static final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    private IBuffer buffer = new Buffer();
    private final Container container = null;
    /**
     * create logger class
     */
    private Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);

    /**
     * state machine constructor
     */
    public StateMachineNetworkManager() {
        Container container = new Container();
        IBuffer buffer = new Buffer();
        container.setBuffer(buffer);
        this.stateTransition = new StateTransition();
    }

    /**
     *
     * @param network network
     * @throws NetworkManagerException exception
     */

    public void listen(final INetwork network) throws NetworkManagerException {
        Container container = new Container();
        State currentState = stateTransition.getStartState();
        IBuffer buffer = new Buffer();
        container.setBuffer(buffer);
        CommandRepository commandRepository = new CommandRepository(container);
        MessageFormatter messageFormatter = new MessageFormatter();
        try {
            while (!isInterrupted) {
                while (network.hasPackage()) {
                    NetworkPackage p = network.getPackage();
                    System.out.println(String.format("%1$s: %2$s", p.getType(), currentState.toString()));
//                    container.setState(currentState);
                    container.setPackage(p);
//                    commandRepository.runningCommand();
                    INetworkManagerCommands commands = commandRepository.getCommands(currentState, p.getType());
                    commands.execute();
                    logger.info(messageFormatter.getStringFormatByType(p.getType()));
                    currentState = stateTransition.nextState(currentState, p);
                }
                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e) {
            logger.error("Network manager was interrupted unexpectedly");
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);

        }
    }

    /**
     * stop function
     */
    public void stop() {
        logger.info("Stop");
        isInterrupted = true;
    }
}
