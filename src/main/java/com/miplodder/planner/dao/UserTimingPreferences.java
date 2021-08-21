package com.miplodder.planner.dao;

import com.miplodder.planner.dto.UserTimingPreference;

import javax.persistence.*;

@Entity
@Table(name = "user_timing_preferences")
public class UserTimingPreferences {

    public UserTimingPreferences() {

    }

    public UserTimingPreferences(String dayStartTime, String dayEndTime, String timezone, long userId) {
        this.dayStartTime = dayStartTime;
        this.dayEndTime = dayEndTime;
        this.timezone = timezone;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long preferenceId;
    private String dayStartTime;
    private String dayEndTime;
    private String timezone;
    private long userId;

    public long getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(long preferenceId) {
        this.preferenceId = preferenceId;
    }

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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserTimingPreferences{" +
                "preferenceId=" + preferenceId +
                ", dayStartTime='" + dayStartTime + '\'' +
                ", dayEndTime='" + dayEndTime + '\'' +
                ", timezone='" + timezone + '\'' +
                ", userId=" + userId +
                '}';
    }
}
