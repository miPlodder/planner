package com.miplodder.planner.controller;

import com.miplodder.planner.dto.Schedule;
import com.miplodder.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    @PostMapping("/suggested-time")
    public String findCommonTimeToMeet(@RequestParam List<Long> users, @RequestParam("duration_mins") int durationMins, @RequestParam("count") int count, @RequestBody Schedule schedule) {
        return plannerService.findCommonTimeToMeet(users, durationMins, count, schedule);
    }
}
