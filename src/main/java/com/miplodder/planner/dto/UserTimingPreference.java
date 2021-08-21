package com.miplodder.planner.dto;

public class UserTimingPreference {

    private String dayStartTime;
    private String dayEndTime;
    private String timeZone;
    private long userId;

    public String getDayStartTime() {
        return dayStartTime;
    }

    public void setDayStartTime(String dayStartTime) {
        this.dayStartTime = dayStartTime;
    }

    public String getDayEndTime() {
        return dayEndTime;
    }

    public void setDayEndTime(String dayEndTime) {
        this.dayEndTime = dayEndTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
