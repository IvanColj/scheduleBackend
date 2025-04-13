package org.ptt.schedule.service;

import org.ptt.schedule.dto.StageDTO;

import java.util.List;

public interface StageService {
    List<StageDTO> findAll();
    StageDTO findById(Integer number);

    StageDTO update(StageDTO stage);
    StageDTO save(StageDTO stage);
    void delete(Integer number);
}
