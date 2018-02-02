package ua.glushko.command;

/**
 * Unknown Command
 * @author Mikhail Glushko
 * @version 1.0
 */
public class CommandUnknown implements Command {
    @Override
    public void execute() {
        System.out.println("Unknown command");
    }
}
