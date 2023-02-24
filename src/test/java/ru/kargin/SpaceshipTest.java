package ru.kargin;

import org.junit.Test;

import static org.junit.Assert.*;


public class SpaceshipTest {

    @Test
    public void move() {
        Spaceship spaceship = new Spaceship();

        SpaceshipMove spaceshipMove = new SpaceshipMove();
        spaceshipMove.setPosition(12, 5);
        spaceshipMove.setVelocity(-7, 3);
        spaceship.getCommands().add(spaceshipMove);
        spaceship.move();

    }

    @Test
    public void rotate() {
        Spaceship spaceship = new Spaceship();
        SpaceshipRotate spaceshipRotate = new SpaceshipRotate();
        spaceshipRotate.setPosition(12.0, 5.0);
        spaceshipRotate.setRotate(45);
        spaceship.getCommands().add(spaceshipRotate);
        spaceship.move();
    }

    @Test
    public void rotateExceptionRetry() throws Exception {

        Spaceship spaceship = new Spaceship();
        SpaceshipRotate spaceshipRotate = new SpaceshipRotate();
        spaceshipRotate.setPosition(12.0, 5.0);
        /*spaceshipRotate.setRotate(45);*/
        spaceship.getCommands().add(spaceshipRotate);
        /*попытка поворота*/
        spaceship.move();
        /*берем из очереди событие и выполняем*/
        ICommands command = spaceship.getCommands().element();
        spaceship.move();
        assertTrue(command instanceof RetryCommand);
       /* assertEquals(1, ExceptionLogCommand.i);*/

    }

    @Test
    public void rotateExceptionLogAndRetry() throws Exception {

        Spaceship spaceship = new Spaceship();
        SpaceshipRotate spaceshipRotate = new SpaceshipRotate();
        spaceshipRotate.setPosition(12.0, 5.0);
        /*spaceshipRotate.setRotate(45);*/
        spaceship.getCommands().add(spaceshipRotate);
        /*попытка поворота*/
        spaceship.move();
        /*берем из очереди событие и выполняем*/
        spaceship.move();
        ICommands command = spaceship.getCommands().element();
        spaceship.move();

        assertTrue(command instanceof ExceptionLogCommand);
        /*assertTrue(command.getClass().isAssignableFrom(ExceptionLogCommand.class));*/

    }

}