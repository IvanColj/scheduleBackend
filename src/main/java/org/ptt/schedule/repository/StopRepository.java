package org.ptt.schedule.repository;

import org.ptt.schedule.logic.StopStartEnd;
import org.ptt.schedule.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StopRepository extends JpaRepository<Stop, Integer> {
    Optional<Stop> findById(Integer id);

    @Modifying
    @Query("delete from Stop where id = :number")
    void delete(@Param("number") Integer number);

    @Query("""
            select new org.ptt.schedule.logic.StopStartEnd(
                s.number,
                st1.address,
                st2.address,
                s.weekday,
                s.weekend
            )
            FROM Stages ss
            JOIN ss.number s
                JOIN s.initial st1
                JOIN s.ultimate st2
                WHERE st1.address = :address
            """)
    List<StopStartEnd> getStopStartEnd(String address);
}
