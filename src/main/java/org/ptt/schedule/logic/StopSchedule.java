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
public class StopSchedule {
    String stop;
    LocalTime time;
    Boolean weekdayOrWeekend;
}
