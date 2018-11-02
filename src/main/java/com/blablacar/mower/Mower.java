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
            this.position = new Position(0, 1);
        } else if (Move.RIGHT.equals(move.getCommand())) {
            this.position = new Position(0, 0);
            this.orientation = Orientation.of(Orientation.EAST);
        } else if (Move.LEFT.equals(move.getCommand())) {
            this.position = new Position(0, 0);
            this.orientation = Orientation.of(Orientation.WEST);
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
