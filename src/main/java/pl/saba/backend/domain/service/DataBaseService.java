package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.http.dto.AvailableHoursLongDto;
import pl.saba.backend.http.dto.LashExtDto;
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
    public static List<LashExtDto> styles = new ArrayList<>();


    public static List<AvailableHoursLongDto> getAvailableHours() {
        workHours.stream()
                .forEach(availableHoursLongDto -> deleteBusyHours(availableHoursLongDto));

        return workHours;
    }

    private static void deleteBusyHours(AvailableHoursLongDto availableHoursLongDto) {
        List<Integer> hours = availableHoursLongDto.getHours().stream()
                .filter(workHour -> isAvailableHour(availableHoursLongDto.getDateTimeStamp(), workHour))
                .collect(Collectors.toList());

        availableHoursLongDto.setHours(hours);
    }

    private static boolean isAvailableHour(Long timestamp, Integer workHour) {

        Long availableHourTimestamp = timestamp + (workHour * 60 * 60 * 1000);

//        visits.stream()
//                .filter(visitDto -> visitDto.getVisitTimestamp().equals(availableHourTimestamp))
//                .findFirst()
//                .isPresent();

        return visits.stream()
                .noneMatch(visitDto -> visitDto.getVisitTimestamp().equals(availableHourTimestamp));


    }

    public static List<LashExtDto> getFilteredStyles(EffectType effectType) {
        List<LashExtDto> filteredStyles = styles.stream()
                .filter(lashExtDto -> lashExtDto.getEffectType().equals(effectType))
                .collect(Collectors.toList());

        return filteredStyles;
    }

}
