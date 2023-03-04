package ru.kargin;

public interface IMove extends ICommands {
    int[] getPosition();
    int[] getVelocity();
    void setPosition(int x, int y);
}
