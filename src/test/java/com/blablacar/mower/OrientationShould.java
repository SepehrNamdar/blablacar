package com.blablacar.mower;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OrientationShould {

    @Test
    public void accept_north_direction() {
        Orientation orientation = new Orientation("N");

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo("N");
    }

    @Test
    public void accept_south_direction() {
        Orientation orientation = new Orientation("S");

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo("S");
    }

    @Test
    public void accept_east_direction() {
        Orientation orientation = new Orientation("E");

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo("E");
    }

    @Test
    public void accept_west_direction() {
        Orientation orientation = new Orientation("W");

        String direction = orientation.getDirection();

        Assertions.assertThat(direction).isEqualTo("W");
    }

    @Test(expected = WrongDirectionException.class)
    public void throw_an_exception_when_direction_is_not_north_nor_south_nor_east_nr_west() {
        new Orientation("G");
    }
}
