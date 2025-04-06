package org.ptt.schedule.service;

import org.ptt.schedule.dto.DriverDTO;
import org.ptt.schedule.model.Driver;


import java.util.List;

public interface DriverService {
    List<DriverDTO> findAll();
    DriverDTO findByPassport(String passport);

    Driver save(Driver driver);
    Driver update(Driver driver);
    void deleteByPassport(String passport);
}
