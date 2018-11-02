package com.blablacar.mower;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerShould {

    private Mower mower;

    @Before
    public void init() {
        mower = new Mower(Orientation.NORTH);
    }

    @Test
    public void have_a_position() {
        Position mowerPosition = mower.getPosition();

        assertThat(mowerPosition.getX()).isEqualTo(0);
        assertThat(mowerPosition.getY()).isEqualTo(0);
    }

    @Test
    public void have_an_orientation() {
        assertThat(mower.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void understand_an_orientation() {
        mower.moveTo(Orientation.NORTH);

        Position expectedPosition = new Position(0, 1);
        assertThat(mower.getPosition()).isEqualToComparingFieldByField(expectedPosition);
    }
}