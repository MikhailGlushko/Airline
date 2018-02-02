package ua.glushko.command;

/**
 * Quit Command
 * @author Mikhail Glushko
 * @version 1.0
 */
public class CommandQuit implements Command {
    @Override
    public void execute() {
        System.out.println("Quit command");
    }
}
