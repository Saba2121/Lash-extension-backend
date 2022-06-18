package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.domain.service.HolidayDaysService;
import pl.saba.backend.domain.service.WorkHoursService;
import pl.saba.backend.http.dtoandroid.ScheduleDto;
import pl.saba.backend.http.dtoandroid.WorkHourDto;
import pl.saba.backend.http.dtoweb.AvailableHoursStringDto;
import pl.saba.backend.http.dtoweb.DateDto;
import pl.saba.backend.http.dtoweb.HolidayDto;
import pl.saba.backend.http.dtoweb.WorkDateDto;

import java.util.Date;
import java.util.List;

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
    @GetMapping("/android/work-time")
    public ResponseEntity<ScheduleDto> getWorkTime() {
        ScheduleDto scheduleDto = new ScheduleDto(holidayDaysService.getAllHolidayDays(), workHoursService.getAllWorkHours());
        return ResponseEntity.ok(scheduleDto);
    }

    @GetMapping("/web/work-time")
    public ResponseEntity<List<WorkDateDto>> getWorkHour() {
        List<WorkDateDto> workDatelist = workHoursService.getAllWorkTime();
        return ResponseEntity.ok(workDatelist);
    }

    @PostMapping("/web/work-time")
    public ResponseEntity<Void> addWorkTime(@RequestBody AvailableHoursStringDto availableHoursStringDto) {
        System.out.println("available hours =  " + availableHoursStringDto.getDate().toString());

        for (int i = 0; i < availableHoursStringDto.getHours().size(); i++) {
            System.out.println(availableHoursStringDto.getHours().get(i));
        }
        WorkHourDto workHourDto = new WorkHourDto(availableHoursStringDto.getDate().getTime(),
                availableHoursStringDto.getHours());
        workHoursService.addWorkHours(workHourDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/web/work-time/{id}")
    public ResponseEntity<Void> deleteWorkTime(@PathVariable("id") Integer id) {
        workHoursService.deleteWorkHour(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/web/holiday-dates")
    public ResponseEntity<List<HolidayDto>> getHolidayDates() {
        return ResponseEntity.ok(holidayDaysService.getAllHolidayDates());
    }

    @PostMapping("/web/holiday-dates")
    public ResponseEntity<Void> addHolidayDates(@RequestBody DateDto dateDto) {
        System.out.println("holidays date = " + dateDto.getDate().toString());
        Date date = dateDto.getDate();
        holidayDaysService.addHolidayDays(date);
        System.out.println("size= " + holidayDaysService.getAllHolidayDays().size());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/web/holiday-dates/{id}")
    public ResponseEntity<Void> deleteHolidayDate(@PathVariable("id") Integer id) {
        holidayDaysService.deleteHoliday(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}































