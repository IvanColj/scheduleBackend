package org.ptt.schedule.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    @MapsId("number")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "number", nullable = false)
    private Stage number;

    @MapsId("route")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "route", nullable = false)
    private Route route;

}
