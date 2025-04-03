package org.ptt.schedule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class StagesId implements Serializable {
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "route", nullable = false)
    private Integer route;
}