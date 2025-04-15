package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.StageDTO;
import org.ptt.schedule.model.Stage;
import org.ptt.schedule.service.StageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/stage")
public class StageController {
    private final StageService stageService;

    @GetMapping("all")
    public List<StageDTO> getAll() {
        return stageService.findAll();
    }

    @GetMapping("number/{number}")
    public StageDTO findById(@PathVariable Integer number) {
        return stageService.findById(number);
    }

    @PostMapping("save")
    public Stage save(@RequestBody StageDTO stage) {
        return stageService.save(stage);
    }

    @PatchMapping("update")
    public Stage update(@RequestBody StageDTO stage) {
        return stageService.update(stage);
    }

    @DeleteMapping("delete/{number}")
    public void delete(@PathVariable Integer number) {
        stageService.delete(number);
    }
}
