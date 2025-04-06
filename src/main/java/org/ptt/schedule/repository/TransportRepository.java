package org.ptt.schedule.repository;

import org.ptt.schedule.dto.ScheduleDTO;
import org.ptt.schedule.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransportRepository extends JpaRepository<Transport, String> {
    Optional<Transport> findByNumber(String passport);
    List<Transport> findByType(String type);
    @Query("""
    SELECT new org.ptt.schedule.dto.ScheduleDTO(
        r.number,
        st1.address,
        st2.address,
        r.start,
        s.weekday,
        s.weekdayJam,
        s.weekend,
        s.weekendJam
    )
    FROM Stage s
    JOIN s.initial st1
    JOIN s.ultimate st2
    JOIN s.routes r
    WHERE r IN (
        SELECT e.route
        FROM Exit e
        JOIN e.transport t
        WHERE t.boardNumber = :boardNumber
    )
""")
    List<ScheduleDTO> findBySchedule(@Param("boardNumber") String boardNumber);

    @Query("select distinct t.type from Transport t")
    List<String> findByTypes();

}
