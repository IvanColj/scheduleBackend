package org.ptt.schedule.service;

import org.ptt.schedule.dto.StagesDTO;
import org.ptt.schedule.model.Stages;

import java.util.List;

public interface StagesService {
    List<StagesDTO> findAll();
    List<StagesDTO> findByRoute(Integer route);

    StagesDTO update(StagesDTO stages);
    StagesDTO save(StagesDTO stages);
    void delete(Stages stages);
}
