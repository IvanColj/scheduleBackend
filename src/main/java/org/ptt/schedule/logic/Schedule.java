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
    Boolean weekdayOrWeekend;
    String initial;
    String ultimate;
    LocalTime start;
    LocalTime weekday;
    LocalTime weekend;
    Integer orderNum;
}
