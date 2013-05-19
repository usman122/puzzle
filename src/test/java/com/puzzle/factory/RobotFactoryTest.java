package com.puzzle.factory;

import com.puzzle.model.Coordinates;
import com.puzzle.model.Direction;
import com.puzzle.model.Plateau;
import com.puzzle.model.Robot;
import com.puzzle.reader.Command;
import com.puzzle.reader.RobotInformation;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RobotFactoryTest {

    @Test
    public void createRobotFromRobotInformation(){
        RobotInformation robotInformation = new RobotInformation(new Coordinates(3,4), Direction.E, Command.L, Command.M, Command.R);
        Plateau plateau = new Plateau(new Coordinates(6,6));
        RobotFactory robotFactory = new RobotFactory();

        Robot robot = robotFactory.createRobot(robotInformation, plateau);

        assertThat(robot).isEqualTo(new Robot(robotInformation.geCoordinates(), robotInformation.getDirection(), plateau, robotInformation.getCommands()));
    }

}
