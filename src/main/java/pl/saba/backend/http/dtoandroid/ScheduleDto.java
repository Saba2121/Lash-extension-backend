package pl.saba.backend.http.dtoandroid;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScheduleDto {

    private List<Date> holidayDates;
    private List<WorkHourDto> availableHours;

}

