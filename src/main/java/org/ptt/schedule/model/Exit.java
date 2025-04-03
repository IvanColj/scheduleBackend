package org.ptt.schedule.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "exit")
public class Exit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transport", nullable = false)
    private Transport transport;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "route", nullable = false)
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver", nullable = false)
    private Driver driver;

}