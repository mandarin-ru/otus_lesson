package ru.kargin;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipRotateTest {

    @Test
    public void move1() {
        SpaceshipRotate spaceshipRotate = new SpaceshipRotate();
        Spaceship spaceship = new Spaceship(spaceshipRotate);
        spaceship.getRotate().setPosition(12.0, 5.0);
        spaceshipRotate.setRotate(45);
        spaceship.getRotate().rotate();
        double compare = 0;
        assertArrayEquals(new double[]{4.9,7.0}, spaceship.getRotate().getPosition(), compare);
    }

    @Test (expected = NullPointerException.class)
    public void move2() {
        SpaceshipRotate spaceshipRotate = new SpaceshipRotate();
        Spaceship spaceship = new Spaceship(spaceshipRotate);
        /*spaceship.getMove().setPosition(12, 5);*/
        spaceshipRotate.setRotate(45);
        double compare = 0;
        assertArrayEquals(new double[]{4.9,7.0}, spaceship.getRotate().getPosition(), compare);
    }

    @Test (expected = NullPointerException.class)
    public void move3() {
        SpaceshipRotate spaceshipRotate = new SpaceshipRotate();
        Spaceship spaceship = new Spaceship(spaceshipRotate);
        spaceship.getMove().setPosition(12, 5);
        /*spaceshipRotate.setRotate(45);*/
        double compare = 0;
        assertArrayEquals(new double[]{4.9,7.0}, spaceship.getRotate().getPosition(), compare);
    }
}