package org.ptt.schedule.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeSchedule {
    Integer number;
    String stopStart;
    String stopEnd;
    LocalTime startTime;
    LocalTime endTime;
    LocalTime time;
    Boolean weekday;

}
