package org.ptt.schedule.service;

import org.ptt.schedule.dto.RouteDTO;
import org.ptt.schedule.model.Route;

import java.util.List;

public interface RouteService {
    List<RouteDTO> findAll();
    RouteDTO findById(Integer number);

    Route update(Route route);
    Route save(Route route);
    void delete(Integer number);
}
