package com.blablacar.mower;

public class WrongDirectionException extends RuntimeException {

    public WrongDirectionException(String errorMessage) {
        super(errorMessage);
    }
}
