package org.ptt.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StageDTO {
    Integer number;
    Integer initial;
    Integer ultimate;
    LocalTime weekday;
    LocalTime weekdayJam;
    LocalTime weekend;
    LocalTime weekendJam;

}
