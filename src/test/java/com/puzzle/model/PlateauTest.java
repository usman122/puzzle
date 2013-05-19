package com.puzzle.model;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PlateauTest {

    @Test
    public void returnFalseWhenTooFarLeft(){
        Plateau plateau = new Plateau(new Coordinates(2,3));
        assertThat(plateau.isCoordinatesValid(-1, 1)).isFalse();
    }

    @Test
    public void returnFalseWhenTooFarRight(){
        Plateau plateau = new Plateau(new Coordinates(2,3));
        assertThat(plateau.isCoordinatesValid(1, 4)).isFalse();
    }

    @Test
    public void returnFalseWhenTooFarNorth(){
        Plateau plateau = new Plateau(new Coordinates(2,3));
        assertThat(plateau.isCoordinatesValid(3, 2)).isFalse();
    }

    @Test
    public void returnFalseWhenTooFarSouth(){
        Plateau plateau = new Plateau(new Coordinates(2,3));
        assertThat(plateau.isCoordinatesValid(1, -1)).isFalse();
    }

    @Test
    public void returnTrueForValidCoordinates(){
        Plateau plateau = new Plateau(new Coordinates(2,3));
        assertThat(plateau.isCoordinatesValid(1, 1)).isTrue();
    }

    @Test
    public void returnTrueForValidCornerCoordinates(){
        Plateau plateau = new Plateau(new Coordinates(2,3));
        assertThat(plateau.isCoordinatesValid(0, 0)).isTrue();
        assertThat(plateau.isCoordinatesValid(2, 3)).isTrue();
        assertThat(plateau.isCoordinatesValid(0, 3)).isTrue();
        assertThat(plateau.isCoordinatesValid(2, 0)).isTrue();
    }

}
