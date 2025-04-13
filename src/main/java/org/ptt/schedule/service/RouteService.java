package org.ptt.schedule.service;

import org.ptt.schedule.dto.RouteDTO;

import java.util.List;

public interface RouteService {
    List<RouteDTO> findAll();
    RouteDTO findById(Integer number);

    RouteDTO update(RouteDTO route);
    RouteDTO save(RouteDTO route);
    void delete(Integer number);
}
