package com.nasa.martians.commands;

import com.nasa.martians.Rover;

public interface ICommand {
    void execute(Rover rover);
}
