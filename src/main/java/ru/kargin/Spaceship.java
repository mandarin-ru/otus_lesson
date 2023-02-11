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

    public void move()  {
        ICommands cmd = commands.poll();
        try {
            cmd.execute();

        }catch (SpaceshipParamException e){

           /* int count = 0;
            int maxTries = 3;
            while(true) {
                try {
                    cmd.execute();
                } catch (SpaceshipParamException e1) {
                    // handle exception
                    if (++count == maxTries) throw e1;
                }
            }*/
            try {
                cmd.execute();
            }catch (SpaceshipParamException e1){
                cmd.cmdLog(e1);
            }
        }
    }
}
