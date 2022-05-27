package pl.saba.backend.domain.service;


import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.workHours.WorkHoursEntity;
import pl.saba.backend.data.table.workHours.WorkHoursEntityJpaRepository;
import pl.saba.backend.http.dto.AvailableHoursLongDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkHoursService {

    private final WorkHoursEntityJpaRepository workHoursEntityJpaRepository;

    public WorkHoursService(WorkHoursEntityJpaRepository workHoursEntityJpaRepository) {
        this.workHoursEntityJpaRepository = workHoursEntityJpaRepository;
    }

    public void addWorkHours(AvailableHoursLongDto availableHoursLongDto) {

        WorkHoursEntity workHoursEntity = new WorkHoursEntity(null, availableHoursLongDto.getDateTimeStamp(),
                mapToString(availableHoursLongDto.getHours()));

        workHoursEntityJpaRepository.save(workHoursEntity);

    }

    public List<AvailableHoursLongDto> getAllAvailableHours() {

        List<WorkHoursEntity> workHoursEntities = workHoursEntityJpaRepository.findAll();
        List<AvailableHoursLongDto> availableHours = workHoursEntities.stream()
                .map(workHoursEntity -> new AvailableHoursLongDto())
                .collect(Collectors.toList());

        return availableHours;
    }

    private String mapToString(List<Integer> hours) {

        List<String> hourAsString = hours.stream()
                .map(integer -> integer.toString())
                .collect(Collectors.toList());

        return String.join(",", hourAsString);

    }
//    private Date mapToDate(Long dateTimeStamp){
//
//
//
//    }

}
