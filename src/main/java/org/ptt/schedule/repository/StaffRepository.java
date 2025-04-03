package org.ptt.schedule.repository;

import org.ptt.schedule.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByLogin(String login);
    List<Staff> findByRole(String role);
    void deleteById(@NonNull Integer id);
}
