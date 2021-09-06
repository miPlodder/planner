package com.miplodder.planner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miplodder.planner.dto.Schedule;
import com.miplodder.planner.dto.Slots;
import com.miplodder.planner.service.PlannerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class PlannerServiceTest {

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindCommonTimeToMeet_WhenS1EqualsE2() throws IOException {
        Schedule schedule = (Schedule) readFromFile("suggested_time_endpoint_request1.json", Schedule.class);
        Slots expected = (Slots) readFromFile("suggested_time_endpoint_response1.json", Slots.class);

        Slots actual = plannerService.findCommonTimeToMeet(getUsers(), 60, 3, schedule);

        assertEquals(objectMapper.writeValueAsString(objectMapper.readValue(objectMapper.writeValueAsString(actual), Slots.class)), objectMapper.writeValueAsString(expected));
    }

    @Test
    public void testFindCommonTimeToMeet_WhenDurationMins15AndCount5() throws IOException {
        Schedule schedule = (Schedule) readFromFile("suggested_time_endpoint_request2.json", Schedule.class);
        Slots expected = (Slots) readFromFile("suggested_time_endpoint_response2.json", Slots.class);

        Slots actual = plannerService.findCommonTimeToMeet(getUsers(), 15, 5, schedule);

        assertEquals(objectMapper.writeValueAsString(objectMapper.readValue(objectMapper.writeValueAsString(actual), Slots.class)), objectMapper.writeValueAsString(expected));
    }

    @Test
    public void testFindCommonTimeToMeet_WhenDurationMins30AndCount8() throws IOException {
        Schedule schedule = (Schedule) readFromFile("suggested_time_endpoint_request3.json", Schedule.class);
        Slots expected = (Slots) readFromFile("suggested_time_endpoint_response3.json", Slots.class);

        Slots actual = plannerService.findCommonTimeToMeet(getUsers(), 30, 8, schedule);

        assertEquals(objectMapper.writeValueAsString(objectMapper.readValue(objectMapper.writeValueAsString(actual), Slots.class)), objectMapper.writeValueAsString(expected));
    }

    @Test
    public void testFindCommonTimeToMeet_WhenNoBusyPayload() throws IOException {
        Schedule schedule = (Schedule) readFromFile("suggested_time_endpoint_request4.json", Schedule.class);

        Slots actual = plannerService.findCommonTimeToMeet(getUsers(), 30, 8, schedule);

        assertNull(actual);
    }

    private Object readFromFile(String fileName, Class clazz) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return objectMapper.readValue(file, clazz);
    }

    private List<Long> getUsers() {
        return Arrays.asList(11l, 12l);
    }


}
