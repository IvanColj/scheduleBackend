package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.model.Stop;

import org.ptt.schedule.service.StopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/stop")
public class StopController {
    private StopService stopService;

    @GetMapping("all")
    public List<Stop> getAll() {
        return stopService.findAll();
    }

    @GetMapping("id/{id}")
    public Optional<Stop> get(@PathVariable Integer id) {
        return stopService.findById(id);
    }

    @PostMapping("save")
    public Stop save(@RequestBody Stop stop) {
        return stopService.save(stop);
    }

    @PutMapping("update")
    public Stop update(@RequestBody Stop stop) {
        return stopService.update(stop);
    }

    @DeleteMapping("delete")
    public void delete(@RequestBody Stop stop) {
        stopService.delete(stop);
    }
}
