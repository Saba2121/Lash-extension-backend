package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.domain.service.DataBaseService;
import pl.saba.backend.http.dto.AvailableHoursLongDto;
import pl.saba.backend.http.dto.AvailableHoursStringDto;
import pl.saba.backend.http.dto.DateDto;
import pl.saba.backend.http.dto.WorkTimeDto;

import java.util.Date;

@RequestMapping(value = "/api/v1/")
@RestController
public class WorkTimeController {

    @GetMapping("/work-time")
    public ResponseEntity<WorkTimeDto> getWorkTime() {
        WorkTimeDto workTimeDto = new WorkTimeDto(DataBaseService.holidayDays, DataBaseService.getAvailableHours());
        return ResponseEntity.ok(workTimeDto);
    }

    @PostMapping("/holiday-date")
    public ResponseEntity<Void> addHoliday(@RequestBody DateDto dateDto) {
        System.out.println("holidays date = " + dateDto.getDate().toString());
        Date date = dateDto.getDate();
        DataBaseService.holidayDays.add(date);
        System.out.println("size= " + DataBaseService.holidayDays.size());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/available-hour")
    public ResponseEntity<Void> addAvailableHour(@RequestBody AvailableHoursStringDto availableHoursStringDto) {
        System.out.println("available hours =  " + availableHoursStringDto.getDate().toString());

        for (int i = 0; i < availableHoursStringDto.getHours().size(); i++) {
            System.out.println(availableHoursStringDto.getHours().get(i));
        }
        AvailableHoursLongDto availableHoursLongDto = new AvailableHoursLongDto(availableHoursStringDto.getDate().getTime(),
                availableHoursStringDto.getHours());
        DataBaseService.workHours.add(availableHoursLongDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


}































