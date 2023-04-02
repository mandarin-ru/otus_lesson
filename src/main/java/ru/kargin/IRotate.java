package ru.kargin;

public interface IRotate extends ICommands {
    double[] getPosition();
    double getRotate();
    void setPosition(double x, double y);
    void setRotate(double rotate);
}
