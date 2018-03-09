package com.nasa.martians.commands;

import com.nasa.martians.Rover;

public class NotFoundCommand implements ICommand {
    @Override
    public void execute(Rover rover) {
        throw new IllegalArgumentException("Speak in Martian language, please!");
    }
}
