package com.blablacar.mower;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MoveShould {

    private static final String BAD_DIRECTION = "G";
    private static final String FRONT = Move.FRONT;
    private static final String RIGHT = Move.RIGHT;
    private static final String LEFT = Move.LEFT;

    @Test
    public void accept_front_command() {
        Move move = Move.to(FRONT);

        String direction = move.getCommand();

        Assertions.assertThat(direction).isEqualTo(FRONT);
    }

    @Test
    public void accept_right_command() {
        Move move = Move.to(RIGHT);

        String direction = move.getCommand();

        Assertions.assertThat(direction).isEqualTo(RIGHT);
    }

    @Test
    public void accept_left_command() {
        Move move = Move.to(LEFT);

        String direction = move.getCommand();

        Assertions.assertThat(direction).isEqualTo(LEFT);
    }

    @Test(expected = WrongMoveCommandException.class)
    public void throw_an_exception_when_command_is_not_front_nor_right_nor_left() {
        Move.to(BAD_DIRECTION);
    }

}
