package org.ptt.schedule.service;

import org.ptt.schedule.dto.TransportDTO;
import org.ptt.schedule.logic.Schedule;
import org.ptt.schedule.logic.TimeSchedule;
import org.ptt.schedule.model.Transport;

import java.time.LocalTime;
import java.util.List;

public interface TransportService {
    List<Transport> findAll();
    List<Transport> findByType(String type);
    TransportDTO findByNumber(String number);
    List<Schedule> findBySchedule(String boardNumber);
    List<Schedule> findScheduleByTime(String boardNumber, LocalTime time);
    List<String> findAllTypes();
    List<LocalTime> findAllStarts(String boardNumber);

    Transport save(TransportDTO transport);
    Transport update(TransportDTO transport);
    void delete(Transport transport);
}
