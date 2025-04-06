package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.StagesDTO;
import org.ptt.schedule.model.Stages;
import org.ptt.schedule.service.StagesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/stages")
public class StagesController {
    private final StagesService stagesService;

    @GetMapping("all")
    public List<StagesDTO> findAll() {
        return stagesService.findAll();
    }

    @GetMapping("route/{route}")
    public List<StagesDTO> findByRoute(@PathVariable Integer route) {
        return stagesService.findByRoute(route);
    }

    @PutMapping("update")
    public Stages update(@RequestBody Stages stages) {
        return stagesService.save(stages);
    }

    @PostMapping("save")
    public Stages save(@RequestBody Stages stages) {
        return stagesService.save(stages);
    }

    @DeleteMapping("delete")
    public void delete(@RequestBody Stages stages) {
        stagesService.delete(stages);
    }
}
