package ru.kargin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import java.io.IOException;
import static org.junit.Assert.*;

public class SpaceshipTest {
    @Test
    public void move1() {
        Spaceship spaceship = new Spaceship(new SpaceshipMove(12, 5, -7, 3));
        spaceship.getMove().move();
        double compare = 0;
        assertArrayEquals(new int[]{5,8}, spaceship.getMove().getPosition());
    }


}