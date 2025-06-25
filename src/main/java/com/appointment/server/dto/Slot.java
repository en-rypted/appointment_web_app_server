package com.appointment.server.dto;

public enum Slot {

    MORNING("08:00"),
    AFTERNOON("12:01"),
    EVENING("16:01");

    private final String startTime;


    Slot(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }



    @Override
    public String toString() {
        return this.name() + " (" + startTime +")";
    }

}
