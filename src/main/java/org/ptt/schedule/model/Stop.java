package org.ptt.schedule.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "address", nullable = false, length = 146)
    private String address;

    @Column(name = "name", nullable = false, length = 146)
    private String name;

    @OneToMany(mappedBy = "initial")
    @JsonIgnore
    private Set<Stage> initial = new LinkedHashSet<>();

    @OneToMany(mappedBy = "ultimate")
    @JsonIgnore
    private Set<Stage> ultimate = new LinkedHashSet<>();
}
