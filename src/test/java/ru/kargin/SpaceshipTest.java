package ru.kargin;

import org.junit.Test;
import ru.kargin.exceptions.SpaceshipParamException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class SpaceshipTest {

    @Test
    public void move33() {
        Spaceship spaceship = new Spaceship();

        SpaceshipMove spaceshipMove = new SpaceshipMove();
        spaceshipMove.setPosition(12, 5);
        spaceshipMove.setVelocity(-7, 3);
        spaceship.getCommands().add(spaceshipMove);

        SpaceshipRotate spaceshipRotate = new SpaceshipRotate();
        spaceshipRotate.setPosition(12.0, 5.0);
        spaceshipRotate.setRotate(45);
        spaceship.getCommands().add(spaceshipRotate);
        ICommands cmd = spaceship.getCommands().poll();

        spaceship.move();
    }
}