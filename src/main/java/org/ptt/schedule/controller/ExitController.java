package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.ExitDTO;
import org.ptt.schedule.model.Exit;
import org.ptt.schedule.service.ExitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/exit")
public class ExitController {
    private final ExitService exitService;

    @GetMapping("all")
    public List<ExitDTO> findAll() {
        return exitService.findAll();
    }

    @GetMapping("number/{number}")
    public ExitDTO number(@PathVariable Integer number) {
        return exitService.findById(number);
    }

    @PostMapping("save")
    public Exit save(@RequestBody ExitDTO exit) {
        return exitService.save(exit);
    }

    @PatchMapping("update")
    public Exit update(@RequestBody ExitDTO exit) {
        return exitService.save(exit);
    }

    @DeleteMapping("delete/{number}")
    public void delete(@PathVariable Integer number) {
        exitService.delete(number);
    }
}
