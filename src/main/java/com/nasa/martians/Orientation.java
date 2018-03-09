package com.nasa.martians;

public enum Orientation {

    N(0),
    E(1),
    S(2),
    W(3);

    private int value;

    Orientation(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}