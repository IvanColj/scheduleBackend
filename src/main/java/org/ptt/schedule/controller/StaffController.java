package org.ptt.schedule.controller;

import lombok.AllArgsConstructor;
import org.ptt.schedule.model.Staff;
import org.ptt.schedule.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffService staffService;

    @GetMapping("all")
    public List<Staff> findAll() {
        return staffService.findAll();
    }

    @GetMapping("role/{role}")
    public List<Staff> findByRole(@PathVariable("role") String role) {
        return staffService.findByRole(role);
    }

    @GetMapping("login/{login}")
    public Optional<Staff> findByLogin(@PathVariable String login) {
        return staffService.findByLogin(login);
    }

    @PostMapping("save")
    public Staff save(@RequestBody Staff staff) {
        return staffService.save(staff);
    }

    @PatchMapping("update")
    public Staff update(@RequestBody Staff staff) {
        return staffService.update(staff);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        staffService.deleteById(id);
    }
}
