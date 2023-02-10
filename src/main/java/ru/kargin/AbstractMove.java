package ru.kargin;


import ru.kargin.exceptions.SpaceshipParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMove implements IMove {
    protected Integer x = null;
    protected Integer y  = null;
    public Integer xV = null;
    public Integer yV = null;

    public AbstractMove() {

    }

    @Override
    public void execute() {
        if (this.x == null || this.y == null) {
            throw new SpaceshipParamException("Невозможно прочитать координаты");
        }

        if (this.xV == null || this.yV == null) {
            throw new SpaceshipParamException("Невозможно прочитать скорость");
        }
        x += xV;
        y += yV;
    }

    public void cmdLog(SpaceshipParamException e){
        Logger logger = LoggerFactory.getLogger(AbstractMove.class.getName());
        logger.error("some message", e);
    }
}
