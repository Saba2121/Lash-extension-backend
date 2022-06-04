package pl.saba.backend.domain.service;


import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.workHours.WorkHoursEntity;
import pl.saba.backend.data.table.workHours.WorkHoursEntityJpaRepository;
import pl.saba.backend.domain.utils.StringUtils;
import pl.saba.backend.http.dto.WorkHourDto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkHoursService {

    private final WorkHoursEntityJpaRepository workHoursEntityJpaRepository;

    public WorkHoursService(WorkHoursEntityJpaRepository workHoursEntityJpaRepository) {
        this.workHoursEntityJpaRepository = workHoursEntityJpaRepository;
    }

    public void addWorkHours(WorkHourDto workHourDto) {
        WorkHoursEntity workHoursEntity = new WorkHoursEntity(null, new Date(),
                mapToString(workHourDto.getHours()));
        workHoursEntityJpaRepository.save(workHoursEntity);

    }

    public List<WorkHourDto> getAllAvailableHours() {
        List<WorkHoursEntity> workHoursEntities = workHoursEntityJpaRepository.findAll();
        List<WorkHourDto> availableHours = workHoursEntities.stream()
                .map(workHoursEntity -> new WorkHourDto(workHoursEntity.getDateTimeStamp().getTime(),
                        StringUtils.convertToIntegersByComma(workHoursEntity.getHours())))
                .collect(Collectors.toList());
        return availableHours;
    }

    private String mapToString(List<Integer> hours) {

        List<String> hourAsString = hours.stream()
                .map(integer -> integer.toString())
                .collect(Collectors.toList());
        return String.join(",", hourAsString);

    }


}
