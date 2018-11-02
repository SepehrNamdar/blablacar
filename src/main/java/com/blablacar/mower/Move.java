package com.blablacar.mower;

public class Move {
    public static final String FRONT = "F";
    public static final String RIGHT = "R";
    public static final String LEFT = "L";

    private final String command;

    public Move() {
        command = FRONT;
    }

    public static Move to(String command) {
        return new Move(command);
    }

    private Move(String command) {
        if (command.equals(FRONT) || command.equals(RIGHT) || command.equals(LEFT)) {
            this.command = command;
        } else {
            throw new WrongMoveCommandException(String.format("Move command %s is not supported", command));
        }
    }

    public String getCommand() {
        return command;
    }
}
