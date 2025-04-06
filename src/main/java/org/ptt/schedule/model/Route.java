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
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "start", nullable = false)
    private LocalTime start;

    @Column(name = "weekday", nullable = false)
    private Boolean weekday = false;

    @OneToMany(mappedBy = "route")
    @JsonIgnore
    private Set<Exit> exits = new LinkedHashSet<>();


    @ManyToMany
    @JoinTable(name = "stages",
            joinColumns = @JoinColumn(name = "route"),
            inverseJoinColumns = @JoinColumn(name = "number"))
    @JsonIgnore
    private Set<Stage> stages = new LinkedHashSet<>();

}
