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
    public void move1() {
        SpaceshipMove spaceshipMove = new SpaceshipMove();
        Spaceship spaceship = new Spaceship(spaceshipMove);
        spaceship.getMove().setPosition(12, 5);
        spaceshipMove.setVelocity(-7, 3);
        spaceship.getMove().execute();
        double compare = 0;
        assertArrayEquals(new int[]{5,8}, spaceship.getMove().getPosition());
    }

    @Test (expected = NullPointerException.class)
    public void move2() {
        SpaceshipMove spaceshipMove = new SpaceshipMove();
        Spaceship spaceship = new Spaceship(spaceshipMove);
        /*spaceship.getMove().setPosition(12, 5);*/
        spaceshipMove.setVelocity(-7, 3);
        spaceship.getMove().execute();
    }

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