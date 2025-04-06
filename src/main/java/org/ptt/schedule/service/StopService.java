package org.ptt.schedule.service;

import org.ptt.schedule.dto.StopDTO;
import org.ptt.schedule.model.Stop;

import java.util.List;

public interface StopService {
    List<Stop> findAll();
    StopDTO findById(Integer id);

    Stop save(Stop stop);
    Stop update(Stop stop);
    void delete(Stop stop);
}
