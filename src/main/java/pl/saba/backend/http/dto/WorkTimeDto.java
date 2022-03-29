package pl.saba.backend.http.dto;


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
public class WorkTimeDto {

    private List<Date> holidayDates;
    private List<AvailableHoursLongDto> availableHours;

}

