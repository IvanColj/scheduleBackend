package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.StopDTO;
import org.ptt.schedule.logic.StopStartEnd;
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

    @GetMapping("startEnd/{address}")
    public List<StopStartEnd> getStartEnd(@PathVariable String address) {
        return stopService.getStopStartEnd(address);
    }

    @PostMapping("save")
    public Stop save(@RequestBody StopDTO stop) {
        return stopService.save(stop);
    }

    @PatchMapping("update")
    public Stop update(@RequestBody StopDTO stop) {
        return stopService.update(stop);
    }

    @DeleteMapping("delete/{number}")
    public void delete(@PathVariable Integer number) {
        stopService.delete(number);
    }
}
