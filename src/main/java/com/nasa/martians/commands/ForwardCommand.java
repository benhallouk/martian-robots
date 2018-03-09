package com.nasa.martians.commands;

import com.nasa.martians.Rover;

public class ForwardCommand implements ICommand{
    @Override
    public void execute(Rover rover) {
        rover.move();
    }
}
