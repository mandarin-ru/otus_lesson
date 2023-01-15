package ru.kargin;

public interface IMove {
    int[] getPosition();
    int[] getVelocity();
    void move();
}
