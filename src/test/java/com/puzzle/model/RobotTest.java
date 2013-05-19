package com.puzzle.model;

import com.puzzle.reader.Command;
import org.junit.Test;
import org.mockito.Mockito;

import static java.util.Arrays.asList;
import static junit.framework.Assert.fail;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RobotTest {

    @Test
    public void robotMoveNorth() {
        Plateau plateau = Mockito.mock(Plateau.class);
        Robot robot = new Robot(new Coordinates(1, 2), Direction.N, plateau, asList(Command.M));
        when(plateau.isCoordinatesValid(1, 3)).thenReturn(true);

        robot.processInstructions();

        assertThat(robot.getCoordinates().getXCoordinate()).isEqualTo(1);
        assertThat(robot.getCoordinates().getYCoordinate()).isEqualTo(3);
    }

    @Test
    public void robotMoveSouth() {
        Plateau plateau = Mockito.mock(Plateau.class);
        Robot robot = new Robot(new Coordinates(1, 2), Direction.S, plateau, asList(Command.M));
        when(plateau.isCoordinatesValid(1,1)).thenReturn(true);

        robot.processInstructions();

        assertThat(robot.getCoordinates().getXCoordinate()).isEqualTo(1);
        assertThat(robot.getCoordinates().getYCoordinate()).isEqualTo(1);
    }

    @Test
    public void robotMoveEast() {
        Plateau plateau = Mockito.mock(Plateau.class);
        Robot robot = new Robot(new Coordinates(1, 2), Direction.E, plateau, asList(Command.M));
        when(plateau.isCoordinatesValid(2, 2)).thenReturn(true);

        robot.processInstructions();

        assertThat(robot.getCoordinates().getXCoordinate()).isEqualTo(2);
        assertThat(robot.getCoordinates().getYCoordinate()).isEqualTo(2);
    }

    @Test
    public void robotMoveWest() {
        Plateau plateau = Mockito.mock(Plateau.class);
        Robot robot = new Robot(new Coordinates(1, 2), Direction.W, plateau, asList(Command.M));

        when(plateau.isCoordinatesValid(0, 2)).thenReturn(true);

        robot.processInstructions();

        assertThat(robot.getCoordinates().getXCoordinate()).isEqualTo(0);
        assertThat(robot.getCoordinates().getYCoordinate()).isEqualTo(2);
    }

    @Test
    public void throwExceptionWhenRobotReachesEndOfPlateau() {
        Plateau plateau = Mockito.mock(Plateau.class);
        Robot robot = new Robot(new Coordinates(1, 2), Direction.W, plateau, asList(Command.M));

        when(plateau.isCoordinatesValid(0, 2)).thenReturn(false);

        try {
            robot.processInstructions();
            fail("should of thrown an exception");
        }catch (Exception e){
            assertThat(e.getMessage()).isEqualTo("Robot has reached the end of the plateau unable to continue");
        }

    }

}
