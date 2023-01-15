package ru.kargin;

public class Spaceship {

    private IMove move;

    public Spaceship(IMove move){
        this.move = move;
    }

    public IMove getMove() {
        return move;
    }
}
