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
public class StopStartEnd {
    Integer number;
    String stopStart;
    String stopEnd;
    LocalTime weekday;
    LocalTime weekend;
}
