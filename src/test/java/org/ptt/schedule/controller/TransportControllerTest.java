package org.ptt.schedule.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ptt.schedule.dto.TransportDTO;
import org.ptt.schedule.logic.StopSchedule;
import org.ptt.schedule.service.simple.SimpleTransportService;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransportControllerTest {

    @Mock
    private SimpleTransportService simpleTransportService;

    @InjectMocks
    private TransportController transportController;

    @Test
    void findByNumberTest() {
        TransportDTO transportDTO = new TransportDTO();
        transportDTO.setNumber("E654EE77");
        transportDTO.setBoardNumber("2");
        transportDTO.setType("троллейбус");
        transportDTO.setModel("Volvo B9");

        String number = "E654EE77";

        when(simpleTransportService.findByNumber(number)).thenReturn(transportDTO);

        TransportDTO result = transportController.findByNumber(number);

        assertEquals(transportDTO.getNumber(), result.getNumber());
        assertEquals(transportDTO.getBoardNumber(), result.getBoardNumber());
        assertEquals(transportDTO.getType(), result.getType());
        assertEquals(transportDTO.getModel(), result.getModel());
    }

    @Test
    void findBySchedule() {
        List<StopSchedule> stops = List.of(
                new StopSchedule("ул. Ленина, 1", LocalTime.parse("06:30:00"), true),
                new StopSchedule("ул. Победы, 2", LocalTime.parse("06:40:00"), true),
                new StopSchedule("ул. Гагарина, 3", LocalTime.parse("06:55:00"), null)
        );

        Map<Integer, List<StopSchedule>> mockResponse = Collections.singletonMap(1, stops);

        when(simpleTransportService.findBySchedules("someRoute")).thenReturn(mockResponse);

        Map<Integer, List<StopSchedule>> result = transportController.findBySchedules("someRoute");

        assertTrue(result.containsKey(1), "В ответе должен быть ключ '1'");

        List<StopSchedule> resultStops = result.get(1);
        assertNotNull(resultStops, "Список остановок не должен быть null");
        assertEquals(3, resultStops.size(), "Должно быть 3 остановки");

        StopSchedule first = resultStops.get(0);
        assertEquals("ул. Ленина, 1", first.getStop());
        assertEquals(LocalTime.parse("06:30:00"), first.getTime());
        assertEquals(Boolean.TRUE, first.getWeekday());

        StopSchedule second = resultStops.get(1);
        assertEquals("ул. Победы, 2", second.getStop());
        assertEquals(LocalTime.parse("06:40:00"), second.getTime());
        assertEquals(Boolean.TRUE, second.getWeekday());

        StopSchedule third = resultStops.get(2);
        assertEquals("ул. Гагарина, 3", third.getStop());
        assertEquals(LocalTime.parse("06:55:00"), third.getTime());
        assertNull(third.getWeekday(), "weekday должен быть null");
    }
}
