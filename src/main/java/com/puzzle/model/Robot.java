package com.puzzle.model;

import com.puzzle.reader.RobotCoordinates;
import com.puzzle.reader.Command;

import java.util.List;

public class Robot {
    private Direction direction;
    private Plateau plateau;
    private List<Command> commands;
    private Coordinates coordinates;

    public Robot(Coordinates coordinates, Direction direction, Plateau plateau, List<Command> commands) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.plateau = plateau;
        this.commands = commands;
    }


    public void processInstructions() {
        for (Command command : commands) {
            switch (command){
                case M:
                    moveForwardInDirection();
                    break;
                case L:
                    turnLeft();
                    break;
                case R:
                    turnRight();
                    break;
            }
        }
    }

    private void moveForwardInDirection() {
        switch (direction){
            case N:
                coordinates.increaseYCoordinates();
                break;
            case E:
                coordinates.increaseXCoordinates();
                break;
            case S:
                coordinates.decrementYCoordinates();
                break;
            case W:
                coordinates.decrementXCoordinates();
                break;
        }
        verifyNewCoordinatesAreValid();

    }

    private void verifyNewCoordinatesAreValid() {
        if(!plateau.isCoordinatesValid(coordinates.getXCoordinates(), coordinates.getYCoordinates())){
            throw new RuntimeException("Robot has reached the end of the plateau unable to continue");
        }
    }

    private void turnRight() {
        direction = direction.turnRight();
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    public RobotCoordinates getCoordinates() {
        return new RobotCoordinates(coordinates.getXCoordinates(),coordinates.getYCoordinates(), direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (commands != null ? !commands.equals(robot.commands) : robot.commands != null) return false;
        if (coordinates != null ? !coordinates.equals(robot.coordinates) : robot.coordinates != null) return false;
        if (direction != robot.direction) return false;
        if (plateau != null ? !plateau.equals(robot.plateau) : robot.plateau != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + (plateau != null ? plateau.hashCode() : 0);
        result = 31 * result + (commands != null ? commands.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }
}

