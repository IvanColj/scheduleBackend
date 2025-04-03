package org.ptt.schedule.service.simple;

import lombok.AllArgsConstructor;
import org.ptt.schedule.model.Staff;
import org.ptt.schedule.repository.StaffRepository;
import org.ptt.schedule.service.StaffService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleStaffService implements StaffService {
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public List<Staff> findByRole(String role) {
        return staffRepository.findByRole(role);
    }

    @Override
    public Optional<Staff> findByLogin(String login) {
        return staffRepository.findByLogin(login);
    }

    @Override
    public Staff save(Staff staff) {
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        return staffRepository.save(staff);
    }

    @Override
    public Staff update(Staff staff) {
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        return staffRepository.save(staff);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        staffRepository.deleteById(id);
    }


}
