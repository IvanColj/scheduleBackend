package org.ptt.schedule.service;

import org.ptt.schedule.dto.ExitDTO;

import java.util.List;

public interface ExitService {
    List<ExitDTO> findAll();
    ExitDTO findById(Integer number);

    ExitDTO update(ExitDTO exit);
    ExitDTO save(ExitDTO exit);
    void delete(Integer number);
}
