package com.puzzle.reader;

import com.puzzle.model.Direction;

public class RobotCoordinates {
    private int x;
    private int y;
    private Direction direction;

    public RobotCoordinates(int x, int y, Direction direction) {

        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getXCoordinate() {
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotCoordinates that = (RobotCoordinates) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (direction != that.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
