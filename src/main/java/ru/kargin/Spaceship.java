package ru.kargin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kargin.exceptions.SpaceshipParamException;

import java.util.LinkedList;
import java.util.Queue;

public class Spaceship {

    private Queue<ICommands> commands;
    private int i = 0;

    public Spaceship() {
        this.commands = new LinkedList<>();
    }

    public Queue<ICommands> getCommands() {
        return commands;
    }

    public void move() {
        ICommands cmd = commands.poll();
        try {
            cmd.execute();

        } catch (Exception e) {

            cmd.exception();
            ExceptionLogCommand log = new ExceptionLogCommand(e);
            commands.add(log);

            if (!(cmd instanceof RetryCommand)) {
                RetryCommand retryCommand = new RetryCommand(cmd);
                commands.add(retryCommand);
            }

        }
    }
}
