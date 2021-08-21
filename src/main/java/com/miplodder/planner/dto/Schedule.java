package com.miplodder.planner.dto;

public class Schedule {

    private UserId userId1;
    private UserId userId2;

    public UserId getUserId1() {
        return userId1;
    }

    public void setUserId1(UserId userId1) {
        this.userId1 = userId1;
    }

    public UserId getUserId2() {
        return userId2;
    }

    public void setUserId2(UserId userId2) {
        this.userId2 = userId2;
    }
}
