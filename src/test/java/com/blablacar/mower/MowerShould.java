package com.blablacar.mower;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerShould {

    @Test
    public void have_a_position() {
        Mower mower = new Mower();

        Position mowerPosition = mower.getPosition();

        assertThat(mowerPosition.getX()).isEqualTo(0);
        assertThat(mowerPosition.getY()).isEqualTo(0);
    }
}