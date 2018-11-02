package com.blablacar.mower;

public class Mower {
    private Position position;

    public Mower() {
        this.position = new Position();
    }

    public Position getPosition() {
        return this.position;
    }

    public void moveTo(String orientation) {
        this.position = new Position(0, 1);
    }
}
