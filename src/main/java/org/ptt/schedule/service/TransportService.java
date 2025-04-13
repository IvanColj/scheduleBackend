package org.ptt.schedule.service;

import org.ptt.schedule.dto.TransportDTO;
import org.ptt.schedule.dto.ScheduleDTO;
import org.ptt.schedule.model.Transport;

import java.util.List;

public interface TransportService {
    List<Transport> findAll();
    List<Transport> findByType(String type);
    TransportDTO findByNumber(String number);
    List<ScheduleDTO> findBySchedule(String board_number);
    List<String> findAllTypes();

    TransportDTO save(TransportDTO transport);
    TransportDTO update(TransportDTO transport);
    void delete(Transport transport);
}
