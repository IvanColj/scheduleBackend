package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.logic.Schedule;
import org.ptt.schedule.dto.TransportDTO;
import org.ptt.schedule.logic.StopSchedule;
import org.ptt.schedule.logic.TimeSchedule;
import org.ptt.schedule.model.Transport;
import org.ptt.schedule.service.TransportService;
import org.ptt.schedule.service.simple.SimpleTransportService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/transport")
public class TransportController {
    private final TransportService transportService;
    private final SimpleTransportService simpleTransportService;

    @GetMapping("all")
    public List<Transport> findAll() {
        return transportService.findAll();
    }

    @GetMapping("type/{type}")
    public List<Transport> findByType(@PathVariable String type) {
        return transportService.findByType(type);
    }

    @GetMapping("number/{number}")
    public TransportDTO findByNumber(@PathVariable String number) {
        return transportService.findByNumber(number);
    }

    @GetMapping("schedule/{board_number}")
    public List<Schedule> findBySchedule(@PathVariable String board_number) {
        return transportService.findBySchedule(board_number);
    }

    @GetMapping("scheduleByTime/{board_number}/{time}")
    public List<TimeSchedule> findBySchedule(@PathVariable String board_number, @PathVariable LocalTime time) {
        return simpleTransportService.findScheduleTime(board_number, time);
    }

    @GetMapping("schedules/{board_number}")
    public Map<Integer, List<StopSchedule>> findBySchedules(@PathVariable String board_number) {
        return simpleTransportService.findBySchedules(board_number);
    }

    @GetMapping("scheduleTime/{boardNumber}/{time}")
    List<Schedule> findScheduleByTime(@PathVariable String boardNumber, @PathVariable LocalTime time) {
        return transportService.findScheduleByTime(boardNumber, time);
    }

    @GetMapping("starts/{board_number}")
    public List<LocalTime> findAllStarts(@PathVariable String board_number) {
        return simpleTransportService.findAllStarts(board_number);
    }

    @GetMapping("type")
    public List<String> findAllTypes() {
        return transportService.findAllTypes();
    }

    @PostMapping("save")
    public Transport save(@RequestBody TransportDTO transport) {
        return transportService.save(transport);
    }

    @PatchMapping("update")
    public Transport update(@RequestBody TransportDTO transport) {
        return transportService.update(transport);
    }

    @DeleteMapping("delete")
    public void delete(Transport transport) {
        transportService.delete(transport);
    }
}
