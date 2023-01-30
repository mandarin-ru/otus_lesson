package ru.kargin;

public interface IMove {
    int[] getPosition();
    int[] getVelocity();
    void setPosition(int x, int y);
    void move();
}
