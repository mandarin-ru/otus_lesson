package ru.kargin;

public class AbstractRotate {

    protected Double x = null;
    protected Double y = null;
    protected Double rotate = null;
    public void rotate() {
        /*if(this.x == null || this.y == null ){
            throw new NullPointerException("Невозможно прочитать координаты");
        }

        if(this.xV == null || this.yV == null ){
            throw new NullPointerException("Невозможно прочитать скорость");
        }*/
        this.x = this.x*Math.cos( Math.toRadians(this.rotate) ) - this.y*Math.sin( Math.toRadians(this.rotate) );
        this.y = this.x*Math.sin( Math.toRadians(this.rotate) ) + this.y*Math.cos( Math.toRadians(this.rotate) );
/*
        $x= $_GET['x']*cos(1)-$y=$_GET['y']*sin(1);
        $y= $_GET['x']*sin(1)+$y=$_GET['y']*cos(1);*/

    }
}

