package org.ptt.schedule.repository;

import org.ptt.schedule.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StopRepository extends JpaRepository<Stop, Integer> {
    Optional<Stop> findById(Integer id);

    @Modifying
    @Query("delete from Stop where id = :number")
    void delete(@Param("number") Integer number);

}
