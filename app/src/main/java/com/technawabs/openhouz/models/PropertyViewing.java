package com.technawabs.openhouz.models;

import java.sql.Time;

public class PropertyViewing {

    private Time time;
    private String agentName;
    private String agentContactNumber;
    private boolean isViewed;

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getAgentName() {
        return this.agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentContactNumber() {
        return this.agentContactNumber;
    }

    public void setAgentContactNumber(String agentContactNumber) {
        this.agentContactNumber = agentContactNumber;
    }

    public boolean isViewed() {
        return this.isViewed;
    }

    public void setViewed(boolean viewed) {
        this.isViewed = viewed;
    }
}
