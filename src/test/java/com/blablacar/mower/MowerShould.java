package com.blablacar.mower;

import org.junit.Before;
import org.junit.Test;

import java.awt.image.RasterOp;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerShould {

    private static final Orientation NORTH_ORIENTATION = Orientation.of(Orientation.NORTH);
    private static final Orientation EAST_ORIENTATION = Orientation.of(Orientation.EAST);
    private static final Orientation WEST_ORIENTATION = Orientation.of(Orientation.WEST);
    private static final Orientation SOUTH_ORIENTATION = Orientation.of(Orientation.SOUTH);

    private static final Move LEFT = Move.to(Move.LEFT);
    private static final Move RIGHT = Move.to(Move.RIGHT);
    private static final Move FRONT = Move.to(Move.FRONT);

    private Mower mower;

    @Before
    public void init() {
        mower = new Mower(NORTH_ORIENTATION);
    }

    @Test
    public void have_a_position() {
        Position mowerPosition = mower.getPosition();

        assertThat(mowerPosition.getX()).isEqualTo(0);
        assertThat(mowerPosition.getY()).isEqualTo(0);
    }

    @Test
    public void have_an_orientation() {
        assertThat(mower.getOrientation()).isEqualToComparingFieldByField(NORTH_ORIENTATION);
    }

    @Test
    public void move_front_when_receive_front_command() {
        mower.moveTo(FRONT);

        Position expectedPosition = new Position(0, 1);
        assertThat(mower.getPosition()).isEqualToComparingFieldByField(expectedPosition);
    }

    @Test
    public void turn_to_right_when_receive_right_command() {
        mower.moveTo(RIGHT);

        Position expectedPosition = new Position(0, 0);
        assertThat(mower.getPosition()).isEqualToComparingFieldByField(expectedPosition);
        assertThat(mower.getOrientation()).isEqualTo(EAST_ORIENTATION);
    }

    @Test
    public void turn_to_left_when_receive_left_command() {
        mower.moveTo(LEFT);

        Position expectedPosition = new Position(0, 0);
        assertThat(mower.getPosition()).isEqualToComparingFieldByField(expectedPosition);
        assertThat(mower.getOrientation()).isEqualTo(WEST_ORIENTATION);
    }

    @Test
    public void understand_many_move_commands() {
        Position startPosition = new Position(1, 2);
        mower = new Mower(startPosition, NORTH_ORIENTATION);

        mower.moveTo(LEFT);
        mower.moveTo(FRONT);
        mower.moveTo(LEFT);
        mower.moveTo(FRONT);
        mower.moveTo(LEFT);
        mower.moveTo(FRONT);
        mower.moveTo(LEFT);
        mower.moveTo(FRONT);
        mower.moveTo(FRONT);

        Position expectedPosition = new Position(1, 3);
        assertThat(mower.getPosition()).isEqualToComparingFieldByField(expectedPosition);
        assertThat(mower.getOrientation()).isEqualTo(NORTH_ORIENTATION);

        /*startPosition = new Position(3, 3);
        mower = new Mower(startPosition, EAST_ORIENTATION);

        mower.moveTo(FRONT);
        mower.moveTo(FRONT);
        mower.moveTo(RIGHT);
        mower.moveTo(FRONT);
        mower.moveTo(FRONT);
        mower.moveTo(RIGHT);
        mower.moveTo(FRONT);
        mower.moveTo(RIGHT);
        mower.moveTo(RIGHT);
        mower.moveTo(FRONT);

        expectedPosition = new Position(5, 1);
        assertThat(mower.getPosition()).isEqualToComparingFieldByField(expectedPosition);
        assertThat(mower.getOrientation()).isEqualTo(EAST_ORIENTATION);*/
    }

}