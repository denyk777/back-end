package it.sevenbits.courses.sm.manager.sm;

import it.sevenbits.courses.sm.containers.Container;
import it.sevenbits.courses.sm.network.NetworkPackage;

import java.util.HashMap;
import java.util.Map;

/**
 * responsible for the transition between States
 */
public class CommandRepository {
    private final Map<Pair<String, String>, INetworkManagerCommands> commands;
//    private final Container container;

    /**
     *creates a map of the States
     * @param container container
     */
    public CommandRepository(final Container container) {
//        this.container = container;
        commands = new HashMap<>();
        commands.put(new Pair<>("IGNORE", "MESSAGE_START"), new Add(container));

        commands.put(new Pair<>("LISTEN", "MESSAGE"), new Add(container));
        commands.put(new Pair<>("LISTEN", "MESSAGE_FINISH"), new Writer(container));

        commands.put(new Pair<>("TRASH_SUSPICION", "MESSAGE"), new Add(container));
        commands.put(new Pair<>("TRASH_SUSPICION", "TRASH"), new Clear(container));
        commands.put(new Pair<>("TRASH_SUSPICION", "MESSAGE_FINISH"), new Writer(container));

    }

    INetworkManagerCommands getCommands(final State state, final String p) {
        return commands.getOrDefault(new Pair<>(state.toString(), p), new Ignore());
    }


//    /**
//     * changes States
//     */
//    public void runningCommand() {
//        Invoker invoker = new Invoker();
//        invoker.submit(commands.get(new Pair<>(container.getCurrentState().toString(),
//                container.getPackage().getType())));
//    }
}
