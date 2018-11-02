package com.blablacar.mower;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OrientationShould {

    private static final String BAD_ORIENTATION = "G";
    private static final String NORTH = Orientation.NORTH;
    private static final String SOUTH = Orientation.SOUTH;
    private static final String EAST = Orientation.EAST;
    private static final String WEST = Orientation.WEST;

    @Test
    public void accept_north_direction() {
        Orientation orientation = Orientation.of(NORTH);

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo(NORTH);
    }

    @Test
    public void accept_south_direction() {
        Orientation orientation = Orientation.of(SOUTH);

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo(SOUTH);
    }

    @Test
    public void accept_east_direction() {
        Orientation orientation = Orientation.of(EAST);

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo(EAST);
    }

    @Test
    public void accept_west_direction() {
        Orientation orientation = Orientation.of(WEST);

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo(WEST);
    }

    @Test(expected = WrongDirectionException.class)
    public void throw_an_exception_when_direction_is_not_north_nor_south_nor_east_nr_west() {
        Orientation.of(BAD_ORIENTATION);
    }
}
