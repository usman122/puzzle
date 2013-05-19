package com.puzzle.reader;

import com.puzzle.model.Coordinates;
import com.puzzle.model.Direction;

import java.util.ArrayList;
import java.util.List;

public class UserInstructionsFactory {
    public static final String NEW_LINE = "\n";
    public static final int PLATEAU_INFO_INDEX = 0;
    public static final int ROBOT_COORDINATE_INDEX = 1;
    public static final int ROBOT_COMMAND_INDEX = 2;

    UserInstructions createUserInstructionsFromCommandLineInput(String userInput){
        String[] inputValues = userInput.split(NEW_LINE);

        Coordinates coordinates = getPlateauCoordinates(inputValues[PLATEAU_INFO_INDEX]);
        RobotInformation robotInformation = getRobotInformation(inputValues);
        return new UserInstructions(coordinates, robotInformation);
    }

    private RobotInformation getRobotInformation(String[] userInput) {
        String robotsInitialCoordinates = userInput[ROBOT_COORDINATE_INDEX];
        String[] split = robotsInitialCoordinates.split(" ");
        Coordinates initialCoordinates = new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        List<Command> commandList = getCommands(userInput[ROBOT_COMMAND_INDEX]);
        return new RobotInformation(initialCoordinates, Direction.valueOf(split[2]), commandList.toArray(new Command[]{}));
    }

    private List<Command> getCommands(String commands) {
        List<Command> commandList = new ArrayList<Command>();
        for (int index = 0; index < commands.length(); index++) {
            commandList.add(Command.valueOf(Character.toString(commands.charAt(index))));
        }
        return commandList;
    }

    private Coordinates getPlateauCoordinates(String inputValue) {
        String[] coordinates = inputValue.split(" ");
        return new Coordinates(Integer.valueOf(coordinates[0]), Integer.valueOf(coordinates[1]));
    }
}
