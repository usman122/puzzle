package com.puzzle.factory;

import com.puzzle.model.Coordinates;
import com.puzzle.model.Plateau;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PlateauFactoryTest {

    @Test
    public void createPlateauFromCoordinates(){
        PlateauFactory factory = new PlateauFactory();
        Coordinates coordinates = new Coordinates(4, 3);

        Plateau plateau = factory.createPlateau(coordinates);

        assertThat(plateau).isEqualTo(new Plateau(coordinates));
    }



}
