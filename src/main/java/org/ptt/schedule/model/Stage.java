package org.ptt.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "stage")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "initial", nullable = false)
    private Stop initial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "final", nullable = false)
    private Stop ultimate;

    @Column(name = "weekday", nullable = false)
    private LocalTime weekday;

    @Column(name = "weekday_jam", nullable = false)
    private LocalTime weekdayJam;

    @Column(name = "weekend", nullable = false)
    private LocalTime weekend;

    @Column(name = "weekend_jam", nullable = false)
    private LocalTime weekendJam;

    @ManyToMany
    @JoinTable(name = "stages",
            joinColumns = @JoinColumn(name = "number"),
            inverseJoinColumns = @JoinColumn(name = "route"))
    @JsonIgnore
    private Set<Route> routes = new LinkedHashSet<>();

}
