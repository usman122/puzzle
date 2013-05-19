package com.puzzle;

import com.puzzle.factory.PlateauFactory;
import com.puzzle.factory.RobotFactory;
import com.puzzle.reader.*;

public class CommandControlBootstrap {

    public static void main(String args[]){
        PlateauFactory plateauFactory = new PlateauFactory();
        RobotFactory robotFactory = new RobotFactory();
        CommandControlCommunicator commandControlCommunicator = new CommandLineCommunicator(new InputValidator(), new UserInstructionsFactory());
        CommandControl control = new CommandControl(plateauFactory, robotFactory);

        UserInstructions userInstructions = commandControlCommunicator.readInput();
        try {
            RobotCoordinates robotCoordinates = control.processInstructions(userInstructions);
            commandControlCommunicator.sendSuccessfulResult(robotCoordinates);
        }catch (Exception e){
            //handle exception when robot reaches invalid coordinates
            commandControlCommunicator.sendFailureResult(e.getMessage());
        }
    }

}
