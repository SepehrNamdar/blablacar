package com.blablacar.mower;

public class Mower {
    private Position position;
    private Orientation orientation;

    public Mower(Orientation orientation) {
        this.position = new Position();
        this.orientation = orientation;
    }

    public Position getPosition() {
        return this.position;
    }

    public void moveTo(Move move) {
        if (Move.FRONT.equals(move.getCommand())) {
            if(Orientation.of(Orientation.EAST).equals(orientation)) {
                this.position = new Position(getPosition().getX() + 1, getPosition().getY());
            } else {
                this.position = new Position(getPosition().getX(), getPosition().getY() + 1);
            }
        } else if (Move.RIGHT.equals(move.getCommand())) {
            if(Orientation.of(Orientation.NORTH).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.EAST);
            }
            this.position = new Position(getPosition().getX(), getPosition().getY());
        } else if (Move.LEFT.equals(move.getCommand())) {
            if(Orientation.of(Orientation.EAST).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.NORTH);
            } else if (Orientation.of(Orientation.NORTH).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.WEST);
            }
            this.position = new Position(getPosition().getX(), getPosition().getY());
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
