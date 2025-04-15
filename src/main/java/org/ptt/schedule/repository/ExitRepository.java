package org.ptt.schedule.repository;

import org.ptt.schedule.model.Exit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExitRepository extends JpaRepository<Exit, Integer> {
    Optional<Exit> findById(Integer number);
    void deleteByNumber(Integer number);
}
