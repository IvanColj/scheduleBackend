package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.model.Transport;
import org.ptt.schedule.service.TransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/transport")
public class TransportController {
    private final TransportService transportService;

    @GetMapping("all")
    public List<Transport> findAll() {
        return transportService.findAll();
    }

    @GetMapping("type/{type}")
    public List<Transport> findByType(@PathVariable String type) {
        return transportService.findByType(type);
    }

    @GetMapping("number/{number}")
    public Optional<Transport> findByNumber(@PathVariable String number) {
        return transportService.findByNumber(number);
    }

    @PostMapping("save")
    public Transport save(@RequestBody Transport transport) {
        return transportService.save(transport);
    }

    @PutMapping("update")
    public Transport update(@RequestBody Transport transport) {
        return transportService.update(transport);
    }

    @DeleteMapping("delete")
    public void delete(Transport transport) {
        transportService.delete(transport);
    }
}
