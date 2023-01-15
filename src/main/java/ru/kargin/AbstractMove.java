package ru.kargin;


public abstract class AbstractMove implements IMove {
    private int x;
    private int y;
    private int xV;
    private int yV;

    public AbstractMove(int x, int y, int xV, int yV) {
        this.x = x;
        this.y = y;
        this.xV = xV;
        this.yV = yV;
    }

    @Override
    public int[] getPosition() {
        return new int[]{x,y};
    }

    @Override
    public int[] getVelocity() {
        return new int[]{xV,yV};
    }

    @Override
    public void move() {
       x += xV;
       y += yV;
    }
}
