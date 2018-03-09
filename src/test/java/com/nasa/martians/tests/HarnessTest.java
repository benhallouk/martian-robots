package com.nasa.martians.tests;

import com.nasa.martians.MarsProgram;
import com.nasa.martians.Orientation;
import com.nasa.martians.Rover;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class HarnessTest {

    private Rover rover;

    @Before
    public void beforeRoverTest() {
        rover = new Rover();
        rover.createLandscape(5, 3);
    }

    @Test
    public void roverShouldRotateAsPerSampleInput() {
        String expected = "1 1 E";

        rover.setPosition(1, 1, Orientation.valueOf("E"));

        rover.process("RFRFRFRF");
        assertThat(rover.printPosition()).isEqualTo(expected);
    }

    @Test
    public void roverShouldBeLostAsPerSampleInput() {
        String expected = "3 3 N LOST";

        rover.setPosition(3, 2, Orientation.valueOf("N"));

        rover.process("FRRFLLFFRRFLL");
        assertThat(rover.printPosition()).isEqualTo(expected);
    }

    @Test
    public void roverShouldLeftScentAsPerSampleInput() {
        String expected = "2 3 S";

        rover.setPosition(3, 2, Orientation.valueOf("N"));

        rover.process("FRRFLLFFRRFLL");

        rover.setPosition(0, 3, Orientation.valueOf("W"));

        rover.process("LLFFFLFLFL");
        assertThat(rover.printPosition()).isEqualTo(expected);
    }

    @Test
    public void marsProgramShouldComputTheInput() throws FileNotFoundException {
        String output = MarsProgram.getSampleOutput(true);

        assertThat(MarsProgram.getSampleOutput(true)).isEqualTo("1 1 E\n" +
                "3 3 N LOST\n" +
                "2 3 S\n");
    }
}