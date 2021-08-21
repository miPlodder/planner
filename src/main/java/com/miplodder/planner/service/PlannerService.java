package com.miplodder.planner.service;

import com.miplodder.planner.dao.UserTimingPreferences;
import com.miplodder.planner.dto.Busy;
import com.miplodder.planner.dto.Schedule;
import com.miplodder.planner.dto.Slots;
import com.miplodder.planner.repository.UserTimingPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlannerService {

    @Autowired
    private UserTimingPreferenceRepository userTimingPreferenceRepository;

    public Slots findCommonTimeToMeet(List<Long> users, int durationMins, int count, Schedule schedule) {
        if (users.size() != 2) {
            System.out.println("Invalid userId count");
            return null;
        }
        List<UserTimingPreferences> userTimingPreferences1 = userTimingPreferenceRepository.findByUserId(users.get(0));
        List<Busy> busy1 = schedule.getUserId1().getCalendars().getPrimary().getBusy();

        List<UserTimingPreferences> userTimingPreferences2 = userTimingPreferenceRepository.findByUserId(users.get(1));
        List<Busy> busy2 = schedule.getUserId2().getCalendars().getPrimary().getBusy();

        if (userTimingPreferences1.isEmpty() || userTimingPreferences2.isEmpty()) {
            System.out.println("userId incorrect");
            return null;
        }
        int[] dateStart1 = extractStartDate(busy1);
        int[] dateEnd1 = extractEndDate(busy1);
        int[] dateStart2 = extractStartDate(busy2);
        int[] dateEnd2 = extractEndDate(busy2);
        int[] timeStart1 = extractTime(userTimingPreferences1.get(0).getDayStartTime());
        int[] timeEnd1 = extractTime(userTimingPreferences1.get(0).getDayEndTime());
        int[] timeStart2 = extractTime(userTimingPreferences2.get(0).getDayStartTime());
        int[] timeEnd2 = extractTime(userTimingPreferences2.get(0).getDayEndTime());

        if (dateStart1 == null || dateStart2 == null) {
            System.out.println("Problem cannot be solved, since date is unknown from input");
            return null;
        }

        ZoneId zone1 = ZoneId.of(userTimingPreferences1.get(0).getTimezone());
        OffsetDateTime start = OffsetDateTime.of(dateStart1[0], dateStart1[1], dateStart1[2], timeStart1[0], timeStart1[1], 0, 0, zone1.getRules().getOffset(Instant.now()));
        start = start.minusMinutes(durationMins);
        OffsetDateTime end = OffsetDateTime.of(dateStart1[0], dateStart1[1], dateStart1[2], timeStart1[0], timeStart1[1], 0, 0, zone1.getRules().getOffset(Instant.now()));
        OffsetDateTime eod = OffsetDateTime.of(dateEnd1[0], dateEnd1[1], dateEnd1[2], timeEnd1[0], timeEnd1[1], 0, 0, zone1.getRules().getOffset(Instant.now()));

        ZoneId zone2 = ZoneId.of(userTimingPreferences2.get(0).getTimezone());
        OffsetDateTime offsetDateTimeStart2 = OffsetDateTime.of(dateStart2[0], dateStart2[1], dateStart2[2], timeStart2[0], timeStart2[1], 0, 0, zone2.getRules().getOffset(Instant.now()));
        OffsetDateTime offsetDateTimeEnd2 = OffsetDateTime.of(dateEnd2[0], dateEnd2[1], dateEnd2[2], timeEnd2[0], timeEnd2[1], 0, 0, zone2.getRules().getOffset(Instant.now()));

        int counter = 0;

        List<Busy> busy3 = new ArrayList<>();
        while (start.isBefore(eod) || end.isBefore(eod)) {
            start = start.plusMinutes(durationMins);
            end = end.plusMinutes(durationMins);

            // am i online
            if (end.isAfter(eod)) {
                break;
            }

            // is he online
            if (!(start.isAfter(offsetDateTimeStart2) && end.isBefore(offsetDateTimeEnd2))) {
                continue;
            }

            boolean flag = true;

            //am i free
            for (Busy busy : busy1) {
                if (isOverlappingTime(start, end, busy.getStart(), busy.getEnd())) {
                    flag = false;
                    break;
                }
            }

            // is he is free
            for (Busy busy : busy2) {
                if (isOverlappingTime(start, end, busy.getStart(), busy.getEnd())) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                busy3.add(new Busy(start, end));
                counter++;
            }
            if (counter == count)
                break;
        }
        return new Slots(busy3);
    }

    private boolean isOverlappingTime(OffsetDateTime s1, OffsetDateTime e1, OffsetDateTime s2, OffsetDateTime e2) {
        return !(e1.isBefore(s2) || s1.isAfter(e2) || s1.isEqual(e2));
    }

    private int[] extractTime(String input) {
        String[] time1 = input.split(":");
        int[] time2 = new int[3];
        for (int i = 0; i < 2; i++) {
            time2[i] = Integer.parseInt(time1[i]);
        }
        return time2;
    }

    private int[] extractStartDate(List<Busy> busyList) {
        int[] date = new int[3];

        for (Busy busy : busyList) {
            date[0] = busy.getStart().getYear();
            date[1] = busy.getStart().getMonth().getValue();
            date[2] = busy.getStart().getDayOfMonth();
            return date;
        }
        return null;
    }

    private int[] extractEndDate(List<Busy> busyList) {
        int[] date = new int[3];

        for (Busy busy : busyList) {
            date[0] = busy.getEnd().getYear();
            date[1] = busy.getEnd().getMonth().getValue();
            date[2] = busy.getEnd().getDayOfMonth();
            return date;
        }
        return null;
    }
}
