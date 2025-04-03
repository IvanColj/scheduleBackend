package org.ptt.schedule.service;


import org.ptt.schedule.model.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> findAll();
    List<Staff> findByRole(String role);
    Optional<Staff> findByLogin(String login);

    Staff save(Staff staff);
    Staff update(Staff staff);
    void deleteById(Integer id);
}
