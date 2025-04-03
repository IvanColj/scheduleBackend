package org.ptt.schedule.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @Column(name = "passport", nullable = false, length = 11)
    private String passport;

    @Column(name = "lastname", columnDefinition = "driver_name(0, 0) not null")
    private String lastname;

    @Column(name = "name", columnDefinition = "driver_name(0, 0) not null")
    private String name;

    @Column(name = "patronymic", columnDefinition = "driver_name(0, 0) not null")
    private String patronymic;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @OneToMany(mappedBy = "driver")
    private Set<Exit> exits = new LinkedHashSet<>();

}