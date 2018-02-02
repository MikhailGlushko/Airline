package ua.glushko.command;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class CommandFindTest {
    @Test
    public void execute() throws Exception {
        System.setIn(new ByteArrayInputStream("10\n100\n".getBytes(StandardCharsets.UTF_8.name())));
        Command command = CommandFactory.getCommand('3');
        command.execute();
    }

}