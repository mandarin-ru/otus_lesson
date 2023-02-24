package ru.kargin;

public class Spaceship {

    private IMove move;
    private IRotate rotate;

    public Spaceship(IMove move){
        this.move = move;
    }

    public Spaceship(IRotate rotate){
        this.rotate = rotate;
    }

    public IMove getMove() {
        return move;
    }

    public IRotate getRotate() {
        return rotate;
    }
}
