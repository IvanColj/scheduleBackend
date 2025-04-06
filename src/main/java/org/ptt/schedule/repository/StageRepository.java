package org.ptt.schedule.repository;

import org.ptt.schedule.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StageRepository extends JpaRepository<Stage, Integer> {
    Optional<Stage> findById(Integer number);

    void deleteByNumber(Integer number);
}
