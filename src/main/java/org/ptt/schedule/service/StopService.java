package org.ptt.schedule.service;

import org.ptt.schedule.dto.StopDTO;
import org.ptt.schedule.model.Stop;

import java.util.List;

public interface StopService {
    List<Stop> findAll();
    StopDTO findById(Integer id);

    Stop save(StopDTO stop);
    Stop update(StopDTO stop);
    void delete(Integer number);
}
