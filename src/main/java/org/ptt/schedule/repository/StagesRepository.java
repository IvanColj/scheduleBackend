package org.ptt.schedule.repository;

import org.ptt.schedule.dto.StagesDTO;
import org.ptt.schedule.model.Stages;
import org.ptt.schedule.model.StagesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StagesRepository extends JpaRepository<Stages, StagesId> {
    @Query("SELECT new org.ptt.schedule.dto.StagesDTO(s.orderNum, s.id.route, s.id.number) FROM Stages s WHERE s.id.route = :route")
    List<StagesDTO> findByRoute(@Param("route") Integer route);

    @Transactional
    @Modifying
    @Query("DELETE FROM Stages s WHERE s.id.number = :number AND s.id.route = :route AND s.orderNum = :orderNum")
    void deleteByNumberAndRouteAndOrderNum(@Param("number") Integer number,
                                           @Param("route") Integer route,
                                           @Param("orderNum") Integer orderNum);
}
