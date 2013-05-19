package com.puzzle.factory;

import com.puzzle.model.Plateau;
import com.puzzle.model.Robot;
import com.puzzle.reader.RobotInformation;

public class RobotFactory {
    public Robot createRobot(RobotInformation robotInformation, Plateau plateau) {
        return new Robot(robotInformation.geCoordinates(),
                robotInformation.getDirection(),
                plateau, robotInformation.getCommands());
    }
}
