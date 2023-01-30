package ru.kargin;


public abstract class AbstractMove implements IMove {
    protected int x;
    protected int y;
    public int xV;
    public int yV;

    public AbstractMove() {

    }

    @Override
    public void move() {
       x += xV;
       y += yV;
    }
}
