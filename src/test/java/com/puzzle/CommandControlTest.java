package com.puzzle;

import com.puzzle.factory.PlateauFactory;
import com.puzzle.factory.RobotFactory;
import com.puzzle.model.Coordinates;
import com.puzzle.model.Direction;
import com.puzzle.model.Plateau;
import com.puzzle.model.Robot;
import com.puzzle.reader.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CommandControlTest {
    @Mock
    private PlateauFactory plateauFactory;
    @Mock
    private RobotFactory robotFactory;
    @Mock
    private UserInstructions userInstructions;
    @Mock
    private Robot robot;

    private CommandControl commandControl;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        commandControl = new CommandControl(plateauFactory, robotFactory);
    }

    @Test
    public void processUserInstruction(){
        Coordinates coordinates = new Coordinates(6, 6);
        Plateau plateau = new Plateau(coordinates);
        RobotInformation robotInformation = new RobotInformation(new Coordinates(1,2), Direction.N, Command.M, Command.M);
        RobotCoordinates expectedRobotCoordinates = new RobotCoordinates(1, 4, Direction.N);

        when(userInstructions.getPlateauCoordinates()).thenReturn(coordinates);
        when(userInstructions.getRobotInformation()).thenReturn(robotInformation);
        when(plateauFactory.createPlateau(coordinates)).thenReturn(plateau);

        when(robotFactory.createRobot(robotInformation, plateau)).thenReturn(robot);
        when(robot.getCoordinates()).thenReturn(expectedRobotCoordinates);

        RobotCoordinates robotCoordinates = commandControl.processInstructions(userInstructions);

        assertThat(robotCoordinates).isEqualTo(expectedRobotCoordinates);
        verify(plateauFactory).createPlateau(coordinates);
        verify(robotFactory).createRobot(robotInformation, plateau);
        verify(robot).processInstructions();
    }
}
