package com.blablacar.mower;

public class WrongMoveCommandException extends RuntimeException {

    public WrongMoveCommandException(String errorMessage) {
        super(errorMessage);
    }
}
