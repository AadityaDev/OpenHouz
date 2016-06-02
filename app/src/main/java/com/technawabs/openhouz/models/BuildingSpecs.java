package com.technawabs.openhouz.models;

public class BuildingSpecs {

    private boolean isBalconyAvailable;
    private String buildUpArea;
    private String facingDirection;
    private int carPark;
    private String floor;
    private String size;

    public boolean isBalconyAvailable() {
        return isBalconyAvailable;
    }

    public void setBalconyAvailable(boolean balconyAvailable) {
        isBalconyAvailable = balconyAvailable;
    }

    public String getBuildUpArea() {
        return buildUpArea;
    }

    public void setBuildUpArea(String buildUpArea) {
        this.buildUpArea = buildUpArea;
    }

    public String getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(String facingDirection) {
        this.facingDirection = facingDirection;
    }

    public int getCarPark() {
        return carPark;
    }

    public void setCarPark(int carPark) {
        this.carPark = carPark;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
