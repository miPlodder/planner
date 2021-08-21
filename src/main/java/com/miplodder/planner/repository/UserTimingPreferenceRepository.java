package com.miplodder.planner.repository;

import com.miplodder.planner.dao.UserTimingPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTimingPreferenceRepository extends JpaRepository<UserTimingPreferences, Long> {
}
