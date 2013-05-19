package com.puzzle.reader;

public interface CommandControlCommunicator {

    public UserInstructions readInput();

    void sendSuccessfulResult(RobotCoordinates robotCoordinates);

    void sendFailureResult(String message);
}
