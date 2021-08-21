package com.miplodder.planner.service;

import com.miplodder.planner.dao.UserTimingPreferences;
import com.miplodder.planner.dto.UserTimingPreference;
import com.miplodder.planner.repository.UserTimingPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserTimingPreferenceCRUDService {

    @Autowired
    private UserTimingPreferenceRepository userTimingPreferenceRepository;

    public String create(UserTimingPreference userTimingPreference) {
        userTimingPreferenceRepository.save(new UserTimingPreferences(userTimingPreference.getDayStartTime(), userTimingPreference.getDayEndTime(), userTimingPreference.getTimeZone()));
        return "UserTimingPreference Created";
    }

    public String read(long userTimingPreference) {
        Optional<UserTimingPreferences> userTimingPreferences = userTimingPreferenceRepository.findById(userTimingPreference);
        if (userTimingPreferences.isPresent()) {
            return userTimingPreferences.get().toString();
        }
        return "UserTimingPreference not found";
    }

    public String update(long userId, UserTimingPreference requestPayload) {
        Optional<UserTimingPreferences> userTimingPreferences = userTimingPreferenceRepository.findById(userId);
        if (userTimingPreferences.isPresent()) {
            UserTimingPreferences usersTimingPreferences = userTimingPreferences.get();
            usersTimingPreferences.setDayStartTime(requestPayload.getDayStartTime());
            usersTimingPreferences.setDayEndTime(requestPayload.getDayEndTime());
            usersTimingPreferences.setTimezone(requestPayload.getTimeZone());
            userTimingPreferenceRepository.save(usersTimingPreferences);
            return "UserTimingPreference updated";
        }
        return "UserTimingPreference not found";
    }

    public String delete(long userId) {
        try {
            userTimingPreferenceRepository.deleteById(userId);
            return "UserTimingPreference Deleted";
        } catch (EmptyResultDataAccessException ex) {
            return "UserTimingPreference not found";
        }
    }
}
