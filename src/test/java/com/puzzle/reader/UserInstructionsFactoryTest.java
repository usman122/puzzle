package com.puzzle.reader;

import com.puzzle.model.Coordinates;
import com.puzzle.model.Direction;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class UserInstructionsFactoryTest {

    public static final String NEW_LINE = "\n";
    private UserInstructionsFactory factory = new UserInstructionsFactory();

    @Test
    public void validateUserInput(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 5")
                .append(NEW_LINE)
                .append("1 2 N")
                .append(NEW_LINE)
                .append("LM");
        UserInstructions userInstructions = factory.createUserInstructionsFromCommandLineInput(stringBuilder.toString());

        assertThat(userInstructions.getPlateauCoordinates()).isEqualTo(new Coordinates(5,5));
        assertThat(userInstructions.getRobotInformation()).isEqualTo(new RobotInformation(new Coordinates(1,2), Direction.N, Command.L, Command.M));

    }

}
