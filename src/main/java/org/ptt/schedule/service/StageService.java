package org.ptt.schedule.service;

import org.ptt.schedule.dto.StageDTO;
import org.ptt.schedule.model.Stage;

import java.util.List;

public interface StageService {
    List<StageDTO> findAll();
    StageDTO findById(Integer number);

    Stage update(Stage stage);
    Stage save(Stage stage);
    void delete(Integer number);
}
