package ru.kargin;

import ru.kargin.exceptions.CommandException;

public class MoveCommand implements IMove{

    protected Integer x = null;
    protected Integer y  = null;
    public Integer xV = null;
    public Integer yV = null;

    public MoveCommand(Object param) {
    }

   /* public MoveCommand() {

        int a = 10;
    }*/

    @Override
    public int[] getPosition() {
        return new int[]{this.x,this.y};
    }

    protected void setVelocity(int x, int y) {
        xV = x;
        yV = y;
    }

    @Override
    public int[] getVelocity() {
        return new int[]{xV,yV};
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public void execute() throws CommandException {
        if (this.x == null || this.y == null) {
            throw new CommandException("Невозможно прочитать координаты");
        }

        if (this.xV == null || this.yV == null) {
            throw new CommandException("Невозможно прочитать скорость");
        }
        x += xV;
        y += yV;
    }

}

