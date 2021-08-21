package com.miplodder.planner.dto;

import java.util.List;

public class Primary {

    public Primary() {

    }

    public Primary(List<Busy> busy) {
        this.busy = busy;
    }

    private List<Busy> busy;

    public List<Busy> getBusy() {
        return busy;
    }

    public void setBusy(List<Busy> busy) {
        this.busy = busy;
    }
}
