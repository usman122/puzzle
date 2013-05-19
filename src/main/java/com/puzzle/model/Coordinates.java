package com.puzzle.model;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXCoordinates() {
        return x;
    }

    public int getYCoordinates() {
        return y;
    }

    public void increaseYCoordinates() {
        y =y+1;
    }

    public void increaseXCoordinates() {
        x = x+1;
    }

    public void decrementYCoordinates() {
        y = y -1;
    }

    public void decrementXCoordinates() {
        x = x - 1;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }
}
