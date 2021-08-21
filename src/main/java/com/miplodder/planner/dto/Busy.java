package com.miplodder.planner.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class Busy {

    public Busy() {

    }

    public Busy(OffsetDateTime start, OffsetDateTime end) {
        this.start = start;
        this.end = end;
    }

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZZZ")
    private OffsetDateTime start;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZZZ")
    private OffsetDateTime end;

    public OffsetDateTime getStart() {
        return start;
    }

    public void setStart(OffsetDateTime start) {
        this.start = start;
    }

    public OffsetDateTime getEnd() {
        return end;
    }

    public void setEnd(OffsetDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
