package ru.kargin;

public interface IRotate {
    double[] getPosition();
    double getRotate();
    void setPosition(double x, double y);
    void setRotate(double rotate);
    void rotate();
}
