package com.technawabs.openhouz.models;

public class SpaceDetail {

    public int numOfBedrooms;
    public int numOfBathrooms;
    public boolean isFurnished;
    public String propertyType;
    public String availableDate;
    public boolean isHelperRoomAvailable;
    public boolean isGasPipelineAvailable;
    public String deposit;
    public String minimumStay;

    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public int getNumOfBathrooms() {
        return numOfBathrooms;
    }

    public void setNumOfBathrooms(int numOfBathrooms) {
        this.numOfBathrooms = numOfBathrooms;
    }

    public boolean isFurnished() {
        return isFurnished;
    }

    public void setFurnished(boolean furnished) {
        isFurnished = furnished;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public boolean isHelperRoomAvailable() {
        return isHelperRoomAvailable;
    }

    public void setHelperRoomAvailable(boolean helperRoomAvailable) {
        isHelperRoomAvailable = helperRoomAvailable;
    }

    public boolean isGasPipelineAvailable() {
        return isGasPipelineAvailable;
    }

    public void setGasPipelineAvailable(boolean gasPipelineAvailable) {
        isGasPipelineAvailable = gasPipelineAvailable;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getMinimumStay() {
        return minimumStay;
    }

    public void setMinimumStay(String minimumStay) {
        this.minimumStay = minimumStay;
    }

}
