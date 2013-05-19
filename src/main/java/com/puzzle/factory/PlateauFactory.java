package com.puzzle.factory;

import com.puzzle.model.Coordinates;
import com.puzzle.model.Plateau;

public class PlateauFactory {
    public Plateau createPlateau(Coordinates coordinates) {
        return new Plateau(coordinates);
    }
}
