package com.blablacar.mower;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerShould {

    private static final String NORTH = Orientation.NORTH;
    private static final String EAST = Orientation.EAST;

    private Mower mower;

    @Before
    public void init() {
        mower = new Mower(Orientation.of(NORTH));
    }

    @Test
    public void have_a_position() {
        Position mowerPosition = mower.getPosition();

        assertThat(mowerPosition.getX()).isEqualTo(0);
        assertThat(mowerPosition.getY()).isEqualTo(0);
    }

    @Test
    public void have_an_orientation() {
        assertThat(mower.getOrientation()).isEqualToComparingFieldByField(Orientation.of(NORTH));
    }

    @Test
    public void understand_an_orientation() {
        mower.moveTo(Move.to(Move.FRONT));

        Position expectedPosition = new Position(0, 1);
        assertThat(mower.getPosition()).isEqualToComparingFieldByField(expectedPosition);
    }

    @Test
    public void turn_to_right_when_receive_right_command() {
        mower.moveTo(Move.to(Move.RIGHT));

        Position expectedPosition = new Position(0, 0);
        assertThat(mower.getPosition()).isEqualToComparingFieldByField(expectedPosition);
        assertThat(mower.getOrientation()).isEqualTo(Orientation.of(EAST));
    }
}