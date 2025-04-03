package org.ptt.schedule.service;

import org.ptt.schedule.model.Driver;


import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> findAll();
    Optional<Driver> findByPassport(String passport);

    Driver save(Driver driver);
    Driver update(Driver driver);
    void deleteByPassport(String passport);
}
