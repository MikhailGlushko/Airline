package ua.glushko.command;

/**
 * Command factory
 * @author Mikhail Glushko
 * @version 1.0
 */
public class CommandFactory {
    public static Command getCommand(char ch){
        switch (ch){
            case '1': return new CommandCalculate();
            case '2': return new CommandSort();
            case '3': return new CommandFind();
            case 'Q':
            case 'q': return new CommandQuit();
            default:return new CommandUnknown();
        }
    }
}
