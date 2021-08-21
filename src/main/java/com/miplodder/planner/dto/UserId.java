package com.miplodder.planner.dto;

public class UserId {

    public UserId() {

    }

    public UserId(Calendars calendars) {
        this.calendars = calendars;
    }

    private Calendars calendars;

    public Calendars getCalendars() {
        return calendars;
    }

    public void setCalendars(Calendars calendars) {
        this.calendars = calendars;
    }
}
