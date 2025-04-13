package org.ptt.schedule.repository;

import org.ptt.schedule.dto.StopDTO;
import org.ptt.schedule.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StopRepository extends JpaRepository<Stop, Integer> {
    Optional<Stop> findById(Integer id);

    StopDTO update(StopDTO stop);
    StopDTO save(StopDTO stop);
}
