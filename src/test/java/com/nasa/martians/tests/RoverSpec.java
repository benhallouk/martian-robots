package com.nasa.martians.tests;

import com.nasa.martians.Orientation;
import com.nasa.martians.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverSpec {

    private Rover rover;

    @Before
    public void beforeRoverTest() {
        rover = new Rover();
        rover.createLandscape(9, 9);
        rover.setPosition(1, 2, Orientation.N);
    }

    @Test
    public void roverShouldPrintTheActualPosition() {
        assertThat(rover.printPosition()).isEqualTo("1 2 N");
    }

    @Test
    public void roverShouldMoveForwardWhenCommandIsF() {
        rover.process("F");
        assertThat(rover.printPosition()).isEqualTo("1 3 N");
    }

    @Test
    public void roverShouldTurnLeftWhenCommandIsL() {
        rover.process("L");
        assertThat(rover.printPosition()).isEqualTo("1 2 W");
    }

    @Test
    public void roverShouldTurnRightWhenCommandIsR() {
        rover.process("R");
        assertThat(rover.printPosition()).isEqualTo("1 2 E");
    }

    @Test(expected = Exception.class)
    public void roverShouldThrowExceptionWhenCommandIsUnknown() {
        rover.process("X");
    }

    @Test
    public void roverShouldBeAbleToReceiveMultipleCommands() {
        rover.process("RFR");
        assertThat(rover.printPosition()).isEqualTo("2 2 S");
    }

    @Test
    public void roverShouldFallFromEdgeOfTheXEdgeAndGetLostForEver() {
        rover.process("LFFF");
        assertThat(rover.printPosition()).isEqualTo("-2 2 W LOST");
    }

    @Test
    public void roverShouldFallFromEdgeOfTheYEdgeAndGetLostForEver() {
        rover.setPosition(1, 2, Orientation.S);
        rover.process("FFFFFFFF");
        assertThat(rover.printPosition()).isEqualTo("1 -6 S LOST");
    }
}