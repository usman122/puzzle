package com.puzzle;

import com.puzzle.factory.PlateauFactory;
import com.puzzle.factory.RobotFactory;
import com.puzzle.model.Coordinates;
import com.puzzle.model.Plateau;
import com.puzzle.model.Robot;
import com.puzzle.reader.RobotCoordinates;
import com.puzzle.reader.RobotInformation;
import com.puzzle.reader.UserInstructions;

public class CommandControl {
    private PlateauFactory plateauFactory;
    private RobotFactory robotFactory;

    public CommandControl(PlateauFactory plateauFactory, RobotFactory robotFactory) {
        this.plateauFactory = plateauFactory;
        this.robotFactory = robotFactory;
    }

    public RobotCoordinates processInstructions(UserInstructions userInstructions) {
        Coordinates coordinates = userInstructions.getPlateauCoordinates();
        RobotInformation robotInitialCoordinatesAndInstructions = userInstructions.getRobotInformation();

        Plateau plateau = plateauFactory.createPlateau(coordinates);
        Robot robot = robotFactory.createRobot(robotInitialCoordinatesAndInstructions, plateau);
        robot.processInstructions();
        return robot.getCoordinates();

    }

}
