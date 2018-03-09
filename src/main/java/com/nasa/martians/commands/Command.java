package com.nasa.martians.commands;

import java.util.Hashtable;
import java.util.Map;


public class Command {

    private static final Map<Character, ICommand> commands = new Hashtable<>();
    static {
        final Map<Character, ICommand> c = commands;
        c.put('F', new ForwardCommand());
        c.put('L', new TurnLeftCommand());
        c.put('R', new TurnRightCommand());
    }

    public static ICommand parseCommand(Character command)
    {
        if (commands.containsKey(command))
            return commands.get(command);
        return new NotFoundCommand();
    }
}