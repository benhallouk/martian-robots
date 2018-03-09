package com.nasa.martians;

import java.util.Hashtable;

public class Scent {
    private Hashtable<Integer,Boolean> scentsX = new Hashtable<>();
    private Hashtable<Integer,Boolean> scentsY = new Hashtable<>();

    public void add(Integer x, Integer y){
        scentsX.put(x, true);
        scentsY.put(y, true);
    }

    public boolean existForGivenX(Integer x) {
        return scentsX.containsKey(x);
    }

    public boolean existForGivenY(Integer y) { return scentsY.containsKey(y); }
}
