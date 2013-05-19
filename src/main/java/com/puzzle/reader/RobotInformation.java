package com.puzzle.reader;

import com.puzzle.model.Coordinates;
import com.puzzle.model.Direction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RobotInformation {
    private Direction direction;
    private Command[] commands;
    private Coordinates initialCoordinates;

    public RobotInformation(Coordinates initialCoordinates, Direction direction, Command... commands) {
        this.initialCoordinates = initialCoordinates;
        this.direction = direction;
        this.commands = commands;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Command> getCommands() {
        return Collections.unmodifiableList(Arrays.asList(commands));
    }

    public Coordinates geCoordinates() {
        return initialCoordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotInformation that = (RobotInformation) o;

        if (!Arrays.equals(commands, that.commands)) return false;
        if (direction != that.direction) return false;
        if (initialCoordinates != null ? !initialCoordinates.equals(that.initialCoordinates) : that.initialCoordinates != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + (commands != null ? Arrays.hashCode(commands) : 0);
        result = 31 * result + (initialCoordinates != null ? initialCoordinates.hashCode() : 0);
        return result;
    }
}
