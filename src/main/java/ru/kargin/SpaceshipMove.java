package ru.kargin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kargin.exceptions.SpaceshipParamException;

public class SpaceshipMove implements IMove{

    protected Integer x = null;
    protected Integer y  = null;
    public Integer xV = null;
    public Integer yV = null;

    public SpaceshipMove() {
    }

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
    public void execute() throws SpaceshipParamException {
        if (this.x == null || this.y == null) {
            throw new SpaceshipParamException("Невозможно прочитать координаты");
        }

        if (this.xV == null || this.yV == null) {
            throw new SpaceshipParamException("Невозможно прочитать скорость");
        }
        x += xV;
        y += yV;
    }

    public void exception(){
        System.out.println("Ошибка передвижения");
    }

}

