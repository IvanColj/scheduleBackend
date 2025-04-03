package org.ptt.schedule.repository;

import org.ptt.schedule.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransportRepository extends JpaRepository<Transport, String> {
    Optional<Transport> findByNumber(String passport);
    List<Transport> findByType(String type);
}
