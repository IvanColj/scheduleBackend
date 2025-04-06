package org.ptt.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExitDTO {
    private Integer number;
    private String transport;
    private Integer route;
    private String driver;
}
