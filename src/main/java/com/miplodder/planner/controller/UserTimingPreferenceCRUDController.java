package com.miplodder.planner.controller;

import com.miplodder.planner.dto.UserTimingPreference;
import com.miplodder.planner.service.UserTimingPreferenceCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usertimingpreference")
public class UserTimingPreferenceCRUDController {

    @Autowired
    private UserTimingPreferenceCRUDService userTimingPreferenceCRUDService;

    @PostMapping
    public String create(@RequestBody UserTimingPreference userTimingPreference) {
        return userTimingPreferenceCRUDService.create(userTimingPreference);
    }

    @GetMapping("/{userId}")
    public String read(@PathVariable long userId) {
        return userTimingPreferenceCRUDService.read(userId);
    }

    @PutMapping("/{userId}")
    public String update(@PathVariable long userId, @RequestBody UserTimingPreference requestPayload) {
        return userTimingPreferenceCRUDService.update(userId, requestPayload);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable long userId) {
        return userTimingPreferenceCRUDService.delete(userId);
    }
}
