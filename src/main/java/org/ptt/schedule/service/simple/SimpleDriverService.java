package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.model.Driver;
import org.ptt.schedule.repository.DriverRepository;
import org.ptt.schedule.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleDriverService implements DriverService {
    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> findByPassport(String passport) {
        return driverRepository.findByPassport(passport);
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver update(Driver driver) {
        return driverRepository.update(driver);
    }

    @Override
    @Transactional
    public void deleteByPassport(String passport) {
        driverRepository.deleteByPassport(passport);
    }
}
