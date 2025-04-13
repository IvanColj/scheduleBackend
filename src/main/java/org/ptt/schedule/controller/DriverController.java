package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.DriverDTO;
import org.ptt.schedule.model.Driver;
import org.ptt.schedule.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/driver")
public class DriverController {
    private final DriverService driverService;

    @GetMapping("all")
    public List<DriverDTO> getAllDrivers() {
        return driverService.findAll();
    }

    @GetMapping("passport/{passport}")
    public DriverDTO getPassportDriver(@PathVariable String passport) {
        return driverService.findByPassport(passport);
    }

    @PostMapping("save")
    public Driver saveDriver(@RequestBody DriverDTO driver) {
        return driverService.save(driver);
    }

    @PatchMapping("update")
    public Driver updateDriver(@RequestBody DriverDTO driver) {
        return driverService.update(driver);
    }

    @DeleteMapping("delete/{passport}")
    public void deleteDriver(@PathVariable String passport) {
        driverService.deleteByPassport(passport);
    }
}
