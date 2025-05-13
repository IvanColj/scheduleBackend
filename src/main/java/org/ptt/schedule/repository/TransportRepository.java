package org.ptt.schedule.repository;

import org.ptt.schedule.logic.Schedule;
import org.ptt.schedule.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TransportRepository extends JpaRepository<Transport, String> {
    Optional<Transport> findByNumber(String passport);
    List<Transport> findByType(String type);
    @Query("""
    SELECT new org.ptt.schedule.logic.Schedule(
        r.number,
        r.weekday,
        st1.address,
        st2.address,
        r.start,
        s.weekday,
        s.weekend,
        ss.orderNum
    )
    FROM Stage s
    JOIN s.initial st1
    JOIN s.ultimate st2
    JOIN Stages ss ON s.number = ss.id.number
    JOIN ss.route r
    WHERE r IN (
        SELECT e.route
        FROM Exit e
        JOIN e.transport t
        WHERE t.boardNumber = :boardNumber
    ) ORDER BY ss.orderNum, r.number, s.number
""")
    List<Schedule> findBySchedule(@Param("boardNumber") String boardNumber);

    @Query("select distinct t.type from Transport t")
    List<String> findByTypes();


    @Query(
            """
                    SELECT r.start FROM Route r
                             JOIN Exit e ON e.route = r
                             JOIN e.transport t
                    WHERE t.boardNumber = :boardNumber ORDER BY 1
                    """
    )
    List<LocalTime> findAllStarts(@Param("boardNumber") String boardNumber);


    @Query("""
    SELECT new org.ptt.schedule.logic.Schedule(
        r.number,
        r.weekday,
        st1.address,
        st2.address,
        r.start,
        s.weekday,
        s.weekend,
        ss.orderNum
    )
    FROM Stage s
    JOIN s.initial st1
    JOIN s.ultimate st2
    JOIN Stages ss ON s.number = ss.id.number
    JOIN ss.route r
    WHERE r IN (
        SELECT e.route
        FROM Exit e
        JOIN e.transport t
        WHERE t.boardNumber = :boardNumber AND r.start = :time
    ) ORDER BY ss.orderNum, r.number, s.number
""")
    List<Schedule> findScheduleByTime(@Param("boardNumber") String boardNumber, @Param("time") LocalTime time);
}
