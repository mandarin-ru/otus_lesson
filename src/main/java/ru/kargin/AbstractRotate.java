package ru.kargin;

import ru.kargin.exceptions.SpaceshipParamException;

public abstract class AbstractRotate implements IRotate {

    protected Double x = null;
    protected Double y = null;
    protected Double rotate = null;

    public void execute() {
        if (x == null || y == null) {
            throw new NullPointerException("Невозможно прочитать координаты");
        }

        if (rotate == null) {
            throw new NullPointerException("Невозможно прочитать угол поворота");
        }

        x = round(
                x * Math.cos(Math.toRadians(rotate)) 
                        - y * Math.sin(Math.toRadians(rotate)
                ), 1
        );
        y = round(x * Math.sin(Math.toRadians(rotate)) + y * Math.cos(Math.toRadians(rotate)), 1);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public void cmdLog(SpaceshipParamException e){

    }
}

