package com.blablacar.mower;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MoveShould {

    private static final String BAD_DIRECTION = "G";

    @Test
    public void accept_front_command() {
        Move move = new Move(Move.FRONT);

        String direction = move.getCommand();

        Assertions.assertThat(direction).isEqualTo(Move.FRONT);
    }

    @Test
    public void accept_right_command() {
        Move move = new Move(Move.RIGHT);

        String direction = move.getCommand();

        Assertions.assertThat(direction).isEqualTo(Move.RIGHT);
    }

    @Test
    public void accept_left_command() {
        Move move = new Move(Move.LEFT);

        String direction = move.getCommand();

        Assertions.assertThat(direction).isEqualTo(Move.LEFT);
    }

    @Test(expected = WrongMoveCommandException.class)
    public void throw_an_exception_when_command_is_not_front_nor_right_nor_left() {
        new Move(BAD_DIRECTION);
    }

}
