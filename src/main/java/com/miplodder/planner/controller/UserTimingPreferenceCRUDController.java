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

    @GetMapping("/{userTimingPreferenceId}")
    public String read(@PathVariable long userTimingPreferenceId) {
        return userTimingPreferenceCRUDService.read(userTimingPreferenceId);
    }

    @PutMapping("/{userTimingPreferenceId}")
    public String update(@PathVariable long userTimingPreferenceId, @RequestBody UserTimingPreference requestPayload) {
        return userTimingPreferenceCRUDService.update(userTimingPreferenceId, requestPayload);
    }

    @DeleteMapping("/{userTimingPreferenceId}")
    public String delete(@PathVariable long userTimingPreferenceId) {
        return userTimingPreferenceCRUDService.delete(userTimingPreferenceId);
    }
}
