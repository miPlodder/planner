package com.miplodder.planner.service;

import com.miplodder.planner.repository.UserRepository;
import com.miplodder.planner.dao.Users;
import com.miplodder.planner.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCRUDService {

    @Autowired
    private UserRepository userRepository;


    public String create(User user) {
        userRepository.save(new Users(user.getFirstName(), user.getLastName()));
        return "User Created";
    }

    public String read(long userId) {
        Optional<Users> users = userRepository.findById(userId);
        if (users.isPresent()) {
            return users.get().toString();
        }
        return "User not found";
    }

    public String update(long userId, User requestPayload) {
        Optional<Users> users = userRepository.findById(userId);
        if (users.isPresent()) {
            Users users1 = users.get();
            users1.setFirstName(requestPayload.getFirstName());
            users1.setLastName(requestPayload.getLastName());
            userRepository.save(users1);
            return "User updated";
        }
        return "User not found";
    }

    public String delete(long userId) {
        try {
            userRepository.deleteById(userId);
            return "User Deleted";
        } catch (EmptyResultDataAccessException ex) {
            return "User not found";
        }
    }
}
