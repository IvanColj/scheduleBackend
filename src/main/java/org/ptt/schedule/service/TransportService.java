package org.ptt.schedule.service;

import org.ptt.schedule.dto.TransportDTO;
import org.ptt.schedule.logic.Schedule;
import org.ptt.schedule.model.Transport;

import java.util.List;

public interface TransportService {
    List<Transport> findAll();
    List<Transport> findByType(String type);
    TransportDTO findByNumber(String number);
    List<Schedule> findBySchedule(String board_number);
    List<String> findAllTypes();

    Transport save(TransportDTO transport);
    Transport update(TransportDTO transport);
    void delete(Transport transport);
}
