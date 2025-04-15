package org.ptt.schedule.repository;

import org.ptt.schedule.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    Optional<Route> findById(Integer number);
    void deleteByNumber(Integer number);

}
