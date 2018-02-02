package ua.glushko.command;

import org.junit.Test;

/**
 * Created by Misha on 02.02.18.
 */
public class CommandSortTest {
    @Test
    public void execute() throws Exception {
     Command command = CommandFactory.getCommand('2');
     command.execute();
    }

}