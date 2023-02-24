package ru.kargin;

public abstract class  AbstractRotate implements IRotate {

    protected Double x = null;
    protected Double y = null;
    protected Double rotate = null;
    public void rotate() {
        if(this.x == null || this.y == null ){
            throw new NullPointerException("Невозможно прочитать координаты");
        }

        if(this.rotate == null){
            throw new NullPointerException("Невозможно прочитать угол поворота");
        }

        this.x = round (this.x*Math.cos( Math.toRadians(this.rotate) ) - this.y*Math.sin( Math.toRadians(this.rotate) ),1);
        this.y = round(this.x*Math.sin( Math.toRadians(this.rotate) ) + this.y*Math.cos( Math.toRadians(this.rotate) ),1);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}

