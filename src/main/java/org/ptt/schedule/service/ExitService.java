package org.ptt.schedule.service;

import org.ptt.schedule.dto.ExitDTO;
import org.ptt.schedule.model.Exit;

import java.util.List;

public interface ExitService {
    List<ExitDTO> findAll();
    ExitDTO findById(Integer number);

    Exit update(ExitDTO exit);
    Exit save(ExitDTO exit);
    void delete(Integer number);
}
