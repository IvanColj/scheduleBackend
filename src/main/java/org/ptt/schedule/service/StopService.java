package org.ptt.schedule.service;

import org.ptt.schedule.model.Stop;

import java.util.List;
import java.util.Optional;

public interface StopService {
    List<Stop> findAll();
    Optional<Stop> findById(Integer id);

    Stop save(Stop stop);
    Stop update(Stop stop);
    void delete(Stop stop);
}
