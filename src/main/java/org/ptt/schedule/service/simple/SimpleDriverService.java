package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.DriverDTO;
import org.ptt.schedule.model.Driver;
import org.ptt.schedule.repository.DriverRepository;
import org.ptt.schedule.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleDriverService implements DriverService {
    private final DriverRepository driverRepository;

    @Override
    public List<DriverDTO> findAll() {
        List<Driver> drivers = driverRepository.findAll();
        return drivers.stream().map(driver ->
                new DriverDTO(
                        driver.getPassport(),
                        driver.getLastname(),
                        driver.getName(),
                        driver.getPatronymic(),
                        driver.getDateBirth())).toList();
    }

    @Override
    public DriverDTO findByPassport(String passport) {
        Driver driver = driverRepository.findById(passport).orElseThrow();
        return new DriverDTO(
                driver.getPassport(),
                driver.getName(),
                driver.getLastname(),
                driver.getPatronymic(),
                driver.getDateBirth()
        );
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver update(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    @Transactional
    public void deleteByPassport(String passport) {
        driverRepository.deleteByPassport(passport);
    }
}
