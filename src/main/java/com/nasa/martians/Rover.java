package com.nasa.martians;

import com.nasa.martians.commands.Command;

public class Rover {

    private Orientation orientation;
    private Landscape landscape;

    public Rover() {
    }

    public void createLandscape(Integer x, Integer y) {
        landscape = new Landscape(x,y);
    }

    public void setPosition(Integer x, Integer y, Orientation orientation) {
        landscape.setCoordinates(x, y);
        this.orientation = orientation;
    }

    public String printPosition() {
        String status = "";
        if(landscape.isLost())  status = " LOST";
        return landscape.toString() + " " +  orientation.toString() + status;
    }

    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++  ) {
            landscape.isLost();
            process(commands.charAt(idx));
        }
    }

    private void process(Character command) {
        Command.parseCommand(command).execute(this);
    }

    public void move() {
        switch (orientation) {
            case N:
                landscape.moveYForward();
                break;
            case E:
                landscape.moveXForward();
                break;
            case S:
                landscape.moveYBackward();
                break;
            case W:
                landscape.moveXBackward();
                break;
        }
    }

    public void turnLeft() {
        changeDirection(orientation, -1);
    }

    public void turnRight() {
        changeDirection(orientation, 1);
    }


    private void changeDirection(Orientation orientationValue, int directionStep) {
        int directions = Orientation.values().length;
        int index = (directions + orientationValue.getValue() + directionStep) % directions;
        orientation = Orientation.values()[index];
    }
}