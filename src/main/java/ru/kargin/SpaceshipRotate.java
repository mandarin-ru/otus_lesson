package ru.kargin;

import ru.kargin.exceptions.SpaceshipParamException;

public class SpaceshipRotate implements IRotate {
    public SpaceshipRotate() {
    }

    public double[] getPosition() {
        return new double[]{this.x,this.y};
    }

    public double getRotate() {
        return this.rotate;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRotate(double rotate) {
        this.rotate = rotate;
    }


    protected Double x = null;
    protected Double y = null;
    protected Double rotate = null;

    public void execute() throws SpaceshipParamException {
        System.out.println("move");
        if (x == null || y == null) {
            throw new SpaceshipParamException("Невозможно прочитать координаты");
        }

        if (rotate == null) {
            throw new SpaceshipParamException("Невозможно прочитать угол поворота");
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

}

