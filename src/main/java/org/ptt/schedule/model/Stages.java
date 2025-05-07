package org.ptt.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stages")
public class Stages {
    @EmbeddedId
    private StagesId id;

    @Column(name = "order_num", nullable = false)
    private Integer orderNum;

    @MapsId("number")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "number", nullable = false)
    @JsonIgnore
    private Stage number;

    @MapsId("route")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "route", nullable = false)
    @JsonIgnore
    private Route route;

}
