package org.ptt.schedule.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Schedule {
    Integer route;
    boolean weekdayOrWeekend;
    String initial;
    String ultimate;
    LocalTime start;
    LocalTime weekday;
    LocalTime weekdayJam;
    LocalTime weekend;
    LocalTime weekendJam;
}
