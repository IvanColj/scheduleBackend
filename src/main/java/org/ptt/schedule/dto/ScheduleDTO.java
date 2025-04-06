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
public class ScheduleDTO {
    Integer route;
    String initial;
    String ultimate;
    LocalTime start;
    LocalTime weekday;
    LocalTime weekdayJam;
    LocalTime weekend;
    LocalTime weekendJam;
}
