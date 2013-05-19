package com.puzzle.model;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class DirectionTest {
    @Test
    public void turnLeftFromCurrentPosition() throws Exception {
        assertThat(Direction.N.turnLeft()).isEqualTo(Direction.W);
        assertThat(Direction.S.turnLeft()).isEqualTo(Direction.E);
        assertThat(Direction.W.turnLeft()).isEqualTo(Direction.S);
        assertThat(Direction.E.turnLeft()).isEqualTo(Direction.N);

    }

    @Test
    public void turnRightsFromCurrentPosition() throws Exception {
        assertThat(Direction.N.turnRight()).isEqualTo(Direction.E);
        assertThat(Direction.S.turnRight()).isEqualTo(Direction.W);
        assertThat(Direction.W.turnRight()).isEqualTo(Direction.N);
        assertThat(Direction.E.turnRight()).isEqualTo(Direction.S);


    }
}
