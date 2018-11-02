package com.blablacar.mower;

public class Mower {
    private Position position;
    private Orientation orientation;

    public Mower(Orientation startOrientation) {
        this.position = new Position(); // default position is 0, 0
        this.orientation = startOrientation;
    }

    public Mower(Position startPosition, Orientation startOrientation) {
        this.position = startPosition;
        this.orientation = startOrientation;
    }

    public Position getPosition() {
        return this.position;
    }

    // TODO : use polymorphism to avoid violating Open close Principle
    public void moveTo(Move move) {
        if (Move.FRONT.equals(move.getCommand())) {
            if (Orientation.of(Orientation.EAST).equals(orientation)) {
                this.position = new Position(getPosition().getX() + 1, getPosition().getY());
            } else if (Orientation.of(Orientation.WEST).equals(orientation)) {
                this.position = new Position(getPosition().getX() - 1, getPosition().getY());
            } else if (Orientation.of(Orientation.NORTH).equals(orientation)) {
                this.position = new Position(getPosition().getX(), getPosition().getY() + 1);
            } else { // Orientation is south
                this.position = new Position(getPosition().getX(), getPosition().getY() - 1);
            }
        } else if (Move.RIGHT.equals(move.getCommand())) {
            if (Orientation.of(Orientation.NORTH).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.EAST);
            } else if (Orientation.of(Orientation.EAST).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.SOUTH);
            } else if (Orientation.of(Orientation.SOUTH).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.WEST);
            } else if (Orientation.of(Orientation.WEST).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.NORTH);
            }
            this.position = new Position(getPosition().getX(), getPosition().getY());
        } else if (Move.LEFT.equals(move.getCommand())) {
            if (Orientation.of(Orientation.EAST).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.NORTH);
            } else if (Orientation.of(Orientation.NORTH).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.WEST);
            } else if (Orientation.of(Orientation.WEST).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.SOUTH);
            } else if (Orientation.of(Orientation.SOUTH).equals(orientation)) {
                this.orientation = Orientation.of(Orientation.EAST);
            }
            this.position = new Position(getPosition().getX(), getPosition().getY());
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
