package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.domain.service.HolidayDaysService;
import pl.saba.backend.domain.service.WorkHoursService;
import pl.saba.backend.http.dto.AvailableHoursStringDto;
import pl.saba.backend.http.dto.DateDto;
import pl.saba.backend.http.dto.WorkHourDto;
import pl.saba.backend.http.dto.WorkTimeDto;

import java.util.Date;

@RequestMapping(value = "/api/v1/")
@RestController
public class LashExtWorkTimeController {

    private WorkHoursService workHoursService;
    private HolidayDaysService holidayDaysService;

    public LashExtWorkTimeController(WorkHoursService workHoursService, HolidayDaysService holidayDaysService) {
        this.workHoursService = workHoursService;
        this.holidayDaysService = holidayDaysService;
    }

    //    uzywany przez androida
    @GetMapping("/work-time")
    public ResponseEntity<WorkTimeDto> getWorkTime() {
        WorkTimeDto workTimeDto = new WorkTimeDto(holidayDaysService.getAllHolidayDays(), workHoursService.getAllAvailableHours());
        return ResponseEntity.ok(workTimeDto);
    }

    @PostMapping("/holiday-date")
    public ResponseEntity<Void> addHoliday(@RequestBody DateDto dateDto) {
        System.out.println("holidays date = " + dateDto.getDate().toString());
        Date date = dateDto.getDate();
        holidayDaysService.addHolidayDays(date);
        System.out.println("size= " + holidayDaysService.getAllHolidayDays().size());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/available-hour")
    public ResponseEntity<Void> addAvailableHour(@RequestBody AvailableHoursStringDto availableHoursStringDto) {
        System.out.println("available hours =  " + availableHoursStringDto.getDate().toString());

        for (int i = 0; i < availableHoursStringDto.getHours().size(); i++) {
            System.out.println(availableHoursStringDto.getHours().get(i));
        }
        WorkHourDto workHourDto = new WorkHourDto(availableHoursStringDto.getDate().getTime(),
                availableHoursStringDto.getHours());
        workHoursService.addWorkHours(workHourDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


}































