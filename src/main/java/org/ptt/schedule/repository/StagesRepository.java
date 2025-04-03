package org.ptt.schedule.repository;

import org.ptt.schedule.model.Stages;
import org.ptt.schedule.model.StagesId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StagesRepository extends JpaRepository<Stages, StagesId> {
    Optional<Stages> findById(StagesId id);
}
