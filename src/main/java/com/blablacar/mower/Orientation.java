package com.blablacar.mower;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Orientation that = (Orientation) o;
        return Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {

        return Objects.hash(direction);
    }
}
