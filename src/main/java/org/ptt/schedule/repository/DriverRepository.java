package org.ptt.schedule.repository;

import org.ptt.schedule.dto.DriverDTO;
import org.ptt.schedule.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, String> {
    Optional<Driver> findByPassport(String passport);
    void deleteByPassport(String passport);

    DriverDTO save(DriverDTO driver);
    DriverDTO update(DriverDTO exit);
}
