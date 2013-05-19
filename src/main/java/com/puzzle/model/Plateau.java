package com.puzzle.model;

public class Plateau {

    private Coordinates topRightCoordinates;

    public Plateau(Coordinates topRightCoordinates) {
        this.topRightCoordinates = topRightCoordinates;
    }

    public boolean isCoordinatesValid(int x, int y) {
        if(isXCoordinatesOutsidePlateau(x)){
            return false;
        }
        if(isYCoordinatesOutsidePlateau(y)){
            return false;
        }
        return true;


    }

    private boolean isYCoordinatesOutsidePlateau(int y) {
        return y < 0 || y> topRightCoordinates.getYCoordinates();
    }

    private boolean isXCoordinatesOutsidePlateau(int x) {
        return x < 0 || x > topRightCoordinates.getXCoordinates();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plateau plateau = (Plateau) o;

        if (topRightCoordinates != null ? !topRightCoordinates.equals(plateau.topRightCoordinates) : plateau.topRightCoordinates != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return topRightCoordinates != null ? topRightCoordinates.hashCode() : 0;
    }
}
