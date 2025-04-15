package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.dto.RouteDTO;
import org.ptt.schedule.model.Route;
import org.ptt.schedule.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/route")
public class RouteController {
    private final RouteService routeService;

    @GetMapping("all")
    public List<RouteDTO> findAll() {
        return routeService.findAll();
    }

    @GetMapping("number/{number}")
    public RouteDTO findById(@PathVariable Integer number) {
        return routeService.findById(number);
    }

    @PostMapping("save")
    public Route save(@RequestBody RouteDTO route) {
        return routeService.save(route);
    }

    @PatchMapping("update")
    public Route update(@RequestBody RouteDTO route) {
        return routeService.update(route);
    }

    @DeleteMapping("delete/{number}")
    public void delete(@PathVariable Integer number) {
        routeService.delete(number);
    }
}
