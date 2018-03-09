package com.nasa.martians;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MarsProgram {

    public static void main(String args[]) throws IOException {
        System.out.println(getSampleOutput(false));
    }

    public static String getSampleOutput(boolean isTestMode) throws FileNotFoundException {

        Rover rover = new Rover();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        Scanner scan = new Scanner(new File(classloader.getResource("input.txt").getPath()));

        if(!isTestMode)
        System.out.println("Input:");

        if(scan.hasNextLine()){
            String firstLine = scan.nextLine();

            int cx = Integer.parseInt(firstLine.split(" ")[0]);
            int cy = Integer.parseInt(firstLine.split(" ")[1]);

            rover.createLandscape(cx, cy);

            if(!isTestMode)
            System.out.println(firstLine);
        }

        StringBuilder output = new StringBuilder();

        while(scan.hasNextLine()){
            String positionLine = scan.nextLine();

            int x = Integer.parseInt(positionLine.split(" ")[0]);
            int y = Integer.parseInt(positionLine.split(" ")[1]);
            String direction = positionLine.split(" ")[2];

            rover.setPosition(x, y, Orientation.valueOf(direction));

            String commandsLine = scan.nextLine();

            if(!isTestMode)
            System.out.println(commandsLine);

            rover.process(commandsLine);

            if(!isTestMode)
            System.out.println(positionLine);

            output.append(rover.printPosition());
            output.append(System.getProperty("line.separator"));
        }

        if(!isTestMode)
        System.out.println(System.lineSeparator());

        if(!isTestMode)
        System.out.println("Output:");

        return output.toString();
    }
}