package ru.kargin;

import org.junit.Test;
import ru.kargin.exceptions.CommandException;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SpaceshipTest {

    @Test
    public void move() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Spaceship spaceship = new Spaceship();

        IoC container = new IoC();

        IoC.resolve("IoC.Register",
                new Object[] {
                        "move",
                        (Function<Object[], Object>) params -> {
                            MoveCommand obj = new MoveCommand();

                            obj.setPosition(12, 5);
                            obj.setVelocity(-7, 3);
                            /*spaceship.getCommands().add(obj);
                            spaceship.move();*/
                            return obj;
                        }
                });

        MoveCommand moveCommand = IoC.resolve("move", new Object[] {});


        IoC.resolve("IoC.Register",
                new Object[] {
                        "spaceship",
                        (Function<Object[], Object>) params -> {
                            Spaceship obj = new Spaceship();

                            for (Object param : params) {
                                obj.getCommands().add((ICommands)param);
                            }
                            return obj;
                        }
                });
        Spaceship spaceship1 = IoC.resolve("spaceship", new Object[] {moveCommand});
        spaceship1.move();
        assertArrayEquals(new int[]{5,8}, moveCommand.getPosition());

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