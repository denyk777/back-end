package it.sevenbits.courses.sm.manager.sm;

/**
 * responsible for the execution of transitions
 */
public class Invoker {
    /**
     *
     * @param command command
     */
    public void submit(final INetworkManagerCommands command) {
        if (command != null) {
            command.execute();
        }
    }
}
