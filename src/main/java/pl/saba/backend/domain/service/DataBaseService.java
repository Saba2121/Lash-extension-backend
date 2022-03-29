package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.http.dto.AvailableHoursLongDto;
import pl.saba.backend.http.dto.VisitDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataBaseService {

    public static List<Date> holidayDays = new ArrayList<>();
    public static List<AvailableHoursLongDto> workHours = new ArrayList<>();
    public static List<VisitDto> visits = new ArrayList<>();

    public static List<AvailableHoursLongDto> getAvailableHours() {
        workHours.stream()
                .forEach(availableHoursLongDto -> deleteBussyHours(availableHoursLongDto));

        return workHours;
    }

    private static void deleteBussyHours(AvailableHoursLongDto availableHoursLongDto) {
        List<Integer> hours = availableHoursLongDto.getHours().stream()
                .filter(workHour -> isAvailableHour(availableHoursLongDto.getDateTimeStamp(), workHour))
                .collect(Collectors.toList());

        availableHoursLongDto.setHours(hours);


    }

    private static boolean isAvailableHour(Long timestamp, Integer workHour) {

    }


}
