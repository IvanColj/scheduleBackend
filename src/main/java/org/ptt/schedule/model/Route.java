package org.ptt.schedule.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "start", nullable = false)
    private LocalTime start;

    @Column(name = "weekday", nullable = false)
    private Boolean weekday = false;

    @OneToMany(mappedBy = "route")
    private Set<Exit> exits = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "stages",
            joinColumns = @JoinColumn(name = "route"),
            inverseJoinColumns = @JoinColumn(name = "number"))
    private Set<Stage> stages = new LinkedHashSet<>();

}