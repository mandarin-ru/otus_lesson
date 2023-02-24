package ru.kargin;


public abstract class AbstractMove implements IMove {
    protected Integer x = null;
    protected Integer y  = null;
    public Integer xV = null;
    public Integer yV = null;

    public AbstractMove() {

    }

    @Override
    public void move() {
        if(this.x == null || this.y == null ){
            throw new NullPointerException("Невозможно прочитать координаты");
        }

        if(this.xV == null || this.yV == null ){
            throw new NullPointerException("Невозможно прочитать скорость");
        }
       x += xV;
       y += yV;
    }
}
