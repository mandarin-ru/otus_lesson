package ru.kargin;

public class SpaceshipMove extends AbstractMove{
    public SpaceshipMove() {
    }

    @Override
    public int[] getPosition() {
        return new int[]{this.x,this.y};
    }

    protected void setVelocity(int x, int y) {
        this.xV = x;
        this.yV = y;
    }

    @Override
    public int[] getVelocity() {
        return new int[]{this.xV,this.yV};
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

