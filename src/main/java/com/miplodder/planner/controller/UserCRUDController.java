package com.miplodder.planner.controller;


import com.miplodder.planner.dto.User;
import com.miplodder.planner.service.UserCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserCRUDController {

    @Autowired
    private UserCRUDService userCRUDService;

    @PostMapping
    public String create(@RequestBody User user) {
        return userCRUDService.create(user);
    }

    @GetMapping("/{userId}")
    public String read(@PathVariable long userId) {
        return userCRUDService.read(userId);
    }

    @PutMapping("/{userId}")
    public String update(@PathVariable long userId, @RequestBody User requestPayload) {
        return userCRUDService.update(userId, requestPayload);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable long userId) {
        return userCRUDService.delete(userId);
    }

}
