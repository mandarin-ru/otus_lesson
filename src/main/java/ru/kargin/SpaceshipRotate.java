package ru.kargin;

public class SpaceshipRotate extends AbstractRotate{
    public SpaceshipRotate() {
    }

    public double[] getPosition() {
        return new double[]{this.x,this.y};
    }

    public double getRotate() {
        return this.rotate;
    }

    public void setRotate(double rotate) {
        this.rotate = rotate;
    }
}

