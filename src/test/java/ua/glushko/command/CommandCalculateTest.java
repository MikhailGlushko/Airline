package ua.glushko.command;

import org.junit.Test;

/**
 * Created by Misha on 02.02.18.
 */
public class CommandCalculateTest {
    @Test
    public void execute() throws Exception {
        Command command = CommandFactory.getCommand('1');
        command.execute();
    }

}