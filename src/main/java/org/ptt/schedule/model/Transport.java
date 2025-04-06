package org.ptt.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @Column(name = "number", nullable = false, length = 8)
    private String number;

    @Column(name = "type", nullable = false, length = 12)
    private String type;

    @Column(name = "model", nullable = false, length = 57)
    private String model;

    @Column(name = "board_number", nullable = false, length = 6)
    private String boardNumber;

    @OneToMany(mappedBy = "transport")
    @JsonIgnore
    private Set<Exit> exits = new LinkedHashSet<>();

}
