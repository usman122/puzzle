package com.puzzle.reader;

import com.puzzle.model.Coordinates;

public class UserInstructions {
    private Coordinates plateauCoordinates;
    private RobotInformation robotInformation;

    public UserInstructions(Coordinates plateauCoordinates, RobotInformation robotInformation) {
        this.plateauCoordinates = plateauCoordinates;
        this.robotInformation = robotInformation;
    }

    public Coordinates getPlateauCoordinates() {
        return plateauCoordinates;
    }

    public RobotInformation getRobotInformation() {
        return robotInformation;
    }

}
