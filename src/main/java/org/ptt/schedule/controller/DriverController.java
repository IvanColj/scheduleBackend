package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.model.Driver;
import org.ptt.schedule.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/driver")
public class DriverController {
    private final DriverService driverService;

    @GetMapping("all")
    public List<Driver> getAllDrivers() {
        return driverService.findAll();
    }

    @GetMapping("passport/{passport}")
    public Optional<Driver> getPassportDriver(@PathVariable String passport) {
        return driverService.findByPassport(passport);
    }

    @PostMapping("save")
    public Driver saveDriver(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @PutMapping("update")
    public Driver updateDriver(@RequestBody Driver driver) {
        return driverService.update(driver);
    }

    @DeleteMapping("delete/{passport}")
    public void deleteDriver(@PathVariable String passport) {
        driverService.deleteByPassport(passport);
    }
}
