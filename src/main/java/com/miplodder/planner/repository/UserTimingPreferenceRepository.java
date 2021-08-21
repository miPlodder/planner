package com.miplodder.planner.repository;

import com.miplodder.planner.dao.UserTimingPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTimingPreferenceRepository extends JpaRepository<UserTimingPreferences, Long> {

    public List<UserTimingPreferences> findByUserId(long userId);

}
