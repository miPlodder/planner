package com.miplodder.planner.dto;

import java.util.List;

public class Slots {

    private List<Busy> slots;

    public Slots() {

    }

    public Slots(List<Busy> slots) {
        this.slots = slots;
    }

    public List<Busy> getSlots() {
        return slots;
    }

    public void setSlots(List<Busy> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "{" +
                "slots:" + slots +
                '}';
    }
}
