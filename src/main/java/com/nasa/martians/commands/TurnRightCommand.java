package com.nasa.martians.commands;

import com.nasa.martians.Rover;

public class TurnRightCommand implements ICommand {
    @Override
    public void execute(Rover rover) {
        rover.turnRight();
    }
}
