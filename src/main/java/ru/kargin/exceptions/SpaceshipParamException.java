package ru.kargin.exceptions;

public class SpaceshipParamException extends Exception{
    public SpaceshipParamException() {
    }

    public SpaceshipParamException(String message) {
        super(message);
    }

    public SpaceshipParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpaceshipParamException(Throwable cause) {
        super(cause);
    }

    public SpaceshipParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
