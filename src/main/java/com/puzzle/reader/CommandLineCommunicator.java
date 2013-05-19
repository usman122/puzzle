package com.puzzle.reader;

import java.util.Scanner;

public class CommandLineCommunicator implements CommandControlCommunicator {
    private InputValidator inputValidator;
    private UserInstructionsFactory userInstructionsFactory;

    public CommandLineCommunicator(InputValidator inputValidator, UserInstructionsFactory userInstructionsFactory) {
        this.inputValidator = inputValidator;
        this.userInstructionsFactory = userInstructionsFactory;
    }

    public UserInstructions readInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            StringBuilder stringBuilder = new StringBuilder();
            boolean readingInput = true;
            System.out.println("Enter instructions and once finished enter 'exit'");

            while (readingInput) {
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    readingInput = false;
                }else {
                    stringBuilder.append(input).append("\n");
                }
            }

            boolean isValid = inputValidator.validate(stringBuilder.toString());
            if (isValid) {
                return userInstructionsFactory.createUserInstructionsFromCommandLineInput(stringBuilder.toString());
            }
            System.out.println("Your input was invalid please check and try again");
        }
    }

    public void sendSuccessfulResult(RobotCoordinates robotCoordinates) {
        System.out.println(String.format("%d, %d, %s", robotCoordinates.getXCoordinate(), robotCoordinates.getYCoordinate(), robotCoordinates.getDirection()));
    }

    public void sendFailureResult(String message) {
        System.out.println("FAILURE: " + message);
    }

}
