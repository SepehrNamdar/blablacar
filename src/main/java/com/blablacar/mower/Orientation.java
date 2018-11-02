package com.blablacar.mower;

public class Orientation {
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";

    private final String direction;

    public Orientation(String direction) {
        if (direction.equals(NORTH) || direction.equals(SOUTH) || direction.equals(EAST) || direction.equals(WEST)) {
            this.direction = direction;
        } else {
            throw new WrongDirectionException(String.format("Direction %s is not supported", direction));
        }
    }

    public String getDirection() {
        return direction;
    }
}
