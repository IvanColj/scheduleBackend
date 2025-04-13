package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.StopDTO;
import org.ptt.schedule.model.Stop;

import org.ptt.schedule.service.StopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/stop")
public class StopController {
    private StopService stopService;

    @GetMapping("all")
    public List<Stop> getAll() {
        return stopService.findAll();
    }

    @GetMapping("number/{number}")
    public StopDTO get(@PathVariable Integer number) {
        return stopService.findById(number);
    }

    @PostMapping("save")
    public StopDTO save(@RequestBody StopDTO stop) {
        return stopService.save(stop);
    }

    @PatchMapping("update")
    public StopDTO update(@RequestBody StopDTO stop) {
        return stopService.update(stop);
    }

    @DeleteMapping("delete")
    public void delete(@RequestBody Stop stop) {
        stopService.delete(stop);
    }
}
