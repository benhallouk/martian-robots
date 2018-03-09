package com.nasa.martians;

public class Landscape {
    private int coordinateX;
    private int coordinateY;

    private int xSize;
    private int ySize;

    private Scent scent;
    private boolean prohibited;

    Landscape(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        scent = new Scent();
    }

    public void setCoordinates(int x, int y){
        coordinateX = x;
        coordinateY = y;
    }

    public void moveXForward()
    {
        if(canMoveXForward()) coordinateX++;
    }

    private boolean canMoveXForward() {
        boolean result = !exceedXSize() || !scent.existForGivenX(coordinateX+1);
        if(!result) prohibited = true;
        return result;
    }

    public void moveXBackward()
    {
        if(canMoveXBackward()) coordinateX--;
    }

    private boolean canMoveXBackward() {
        boolean result = !belowXCoordinate() || !scent.existForGivenX(coordinateX-1);
        if(!result) prohibited = true;
        return result;
    }

    public void moveYForward()
    {
        if(canMoveYForward()) coordinateY++;
    }

    private boolean canMoveYForward() {
        boolean result = !exceedYSize() || !scent.existForGivenY(coordinateY+1);
        if(!result) prohibited = true;
        return result;
    }

    public void moveYBackward()
    {
        if(canMoveYBackward()) coordinateY--;
    }

    private boolean canMoveYBackward() {
        boolean result = !belowYCoordinate() || !scent.existForGivenY(coordinateY-1);
        if(!result) prohibited = true;
        return result;
    }

    public boolean isLost() {
        return  (exceedYSize() || exceedXSize() || belowYCoordinate() || belowXCoordinate()) && !prohibited;
    }

    private boolean belowXCoordinate() {
        boolean result = coordinateX <= 0;
        if(!result) scent.add(coordinateX,coordinateY);
        return result;
    }

    private boolean belowYCoordinate() {
        boolean result =  coordinateY <= 0;
        if(!result) scent.add(coordinateX,coordinateY);
        return result;
    }

    private boolean exceedXSize() {
        boolean result = coordinateX >= xSize;
        if(!result) scent.add(coordinateX,coordinateY);
        return result;
    }

    private boolean exceedYSize() {
        boolean result = coordinateY >= ySize;
        if(!result) scent.add(coordinateX,coordinateY);
        return result;
    }

    @Override
    public String toString() { return coordinateX + " " +coordinateY ; }

}