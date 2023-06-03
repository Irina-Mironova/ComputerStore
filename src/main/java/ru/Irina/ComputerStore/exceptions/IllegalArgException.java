package ru.Irina.ComputerStore.exceptions;

public class IllegalArgException extends RuntimeException{
    private String message;

    public IllegalArgException(String message) {
        super(message);
    }
}
