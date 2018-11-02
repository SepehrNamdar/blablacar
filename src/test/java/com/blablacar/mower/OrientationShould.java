package com.blablacar.mower;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OrientationShould {

    private static final String BAD_ORIENTATION = "G";

    @Test
    public void accept_north_direction() {
        Orientation orientation = new Orientation(Orientation.NORTH);

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void accept_south_direction() {
        Orientation orientation = new Orientation(Orientation.SOUTH);

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo(Orientation.SOUTH);
    }

    @Test
    public void accept_east_direction() {
        Orientation orientation = new Orientation(Orientation.EAST);

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo(Orientation.EAST);
    }

    @Test
    public void accept_west_direction() {
        Orientation orientation = new Orientation(Orientation.WEST);

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo(Orientation.WEST);
    }

    @Test(expected = WrongDirectionException.class)
    public void throw_an_exception_when_direction_is_not_north_nor_south_nor_east_nr_west() {
        new Orientation(BAD_ORIENTATION);
    }
}
