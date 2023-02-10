package ru.kargin;

import ru.kargin.exceptions.SpaceshipParamException;

import java.util.LinkedList;
import java.util.Queue;

public class Spaceship {

    private Queue<ICommands> commands;

    public Spaceship(){
        this.commands = new LinkedList<>();
    }

    public Queue<ICommands> getCommands() {
        return commands;
    }

    public void move(){
        ICommands cmd = commands.poll();
        try {
            cmd.execute();

        }catch (SpaceshipParamException e){
            cmd.cmdLog(e);
        }catch(Exception e){

        }
    }
}
