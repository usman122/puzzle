package com.puzzle.reader;

import com.puzzle.model.Direction;
import com.puzzle.reader.Command;

public class InputValidator {
    public static final int PLATEAU_INFO_INDEX = 0;
    public static final int ROBOT_COORDINATE_INDEX = 1;
    public static final int ROBOT_COMMAND_INDEX = 2;


    public boolean validate(String userInput) {
        String[] lines = userInput.split("\n");
        if (lines.length != 3) {
            return false;
        }
        String plateauInfo = lines[PLATEAU_INFO_INDEX];
        if (!isPlateauInfoValid(plateauInfo)) {
            return false;
        }
        if (!isRobotCoordinationValid(lines[ROBOT_COORDINATE_INDEX])) {
            return false;
        }
        if (!isRobotCommandValid(lines[ROBOT_COMMAND_INDEX])) {
            return false;
        }
        return true;
    }

    private boolean isRobotCommandValid(String line) {
        return !line.isEmpty() && onlyContains(line, Command.values());
    }

    private boolean onlyContains(String value, Command[] allowedCommands) {
        for (int index = 0; index < value.length(); index++) {
            boolean allowed = false;
            String character = Character.toString(value.charAt(index));
            for (Command command : allowedCommands) {
                if (character.equals(command.name())) {
                    allowed = true;
                }
            }
            if (!allowed) {
                return false;
            }
        }
        return true;
    }

    private boolean isRobotCoordinationValid(String line) {
        String[] values = line.split(" ");
        return values.length == 3 && isValidDigit(values[0]) && isValidDigit(values[1]) && isValidDirection(values[2]);

    }

    private boolean isValidDirection(String value) {
        try {
            Direction.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isPlateauInfoValid(String plateauInfo) {
        String[] digits = plateauInfo.split(" ");
        return digits.length == 2 && isValidDigit(digits[0]) && isValidDigit(digits[1]);
    }

    private boolean isValidDigit(String digit) {
        try {
            Integer.parseInt(digit);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
