package ru.kargin;

import org.junit.Test;
import ru.kargin.exceptions.CommandException;

import static org.junit.Assert.assertEquals;

public class SpaceshipTest {

    @Test
    public void move() {
        Spaceship spaceship = new Spaceship();

        MoveCommand moveCommand = new MoveCommand();
        moveCommand.setPosition(12, 5);
        moveCommand.setVelocity(-7, 3);
        spaceship.getCommands().add(moveCommand);
        spaceship.move();

    }

    @Test
    public void rotate() {
        Spaceship spaceship = new Spaceship();
        RotateCommand rotateCommand = new RotateCommand();
        rotateCommand.setPosition(12.0, 5.0);
        rotateCommand.setRotate(45);
        spaceship.getCommands().add(rotateCommand);
        spaceship.move();
    }

    @Test
    public void rotateExceptionLog() throws CommandException {

        Spaceship spaceship = new Spaceship();
        RotateCommand rotateCommand = new RotateCommand();
        rotateCommand.setPosition(12.0, 5.0);
        /*spaceshipRotate.setRotate(45);*/
        spaceship.getCommands().add(rotateCommand);
        /*попытка поворота*/
        spaceship.move();
        /*берем из очереди событие и выполняем*/
        spaceship.move();
        assertEquals(1, ExceptionLogCommand.i);

    }

    @Test
    public void rotateExceptionLogAndRetry() throws CommandException {

        Spaceship spaceship = new Spaceship();
        RotateCommand rotateCommand = new RotateCommand();
        rotateCommand.setPosition(12.0, 5.0);
        /*spaceshipRotate.setRotate(45);*/
        spaceship.getCommands().add(rotateCommand);
        /*попытка поворота*/
        spaceship.move();
        /*берем из очереди событие и выполняем*/
        spaceship.move();
        spaceship.move();
        assertEquals(1, RetryCommand.i);
    }

}