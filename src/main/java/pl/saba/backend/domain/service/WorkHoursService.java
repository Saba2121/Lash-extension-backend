package pl.saba.backend.domain.service;


import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.workhours.WorkHoursEntity;
import pl.saba.backend.data.table.workhours.WorkHoursEntityJpaRepository;
import pl.saba.backend.domain.utils.StringUtils;
import pl.saba.backend.http.dtoandroid.WorkHourDto;
import pl.saba.backend.http.dtoweb.WorkDateDto;

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

    public List<WorkHourDto> getAllWorkHours() {
        List<WorkHoursEntity> workHoursEntities = workHoursEntityJpaRepository.findAll();
        List<WorkHourDto> workHours = workHoursEntities.stream()
                .map(workHoursEntity -> new WorkHourDto(workHoursEntity.getDate().getTime(),
                        StringUtils.convertToIntegersByComma(workHoursEntity.getHours())))
                .collect(Collectors.toList());
        return workHours;
    }

    private String mapToString(List<Integer> hours) {

        List<String> hourAsString = hours.stream()
                .map(integer -> integer.toString())
                .collect(Collectors.toList());
        return String.join(",", hourAsString);

    }

    public List<WorkDateDto> getAllWorkTime() {

        List<WorkHoursEntity> workHoursEntities = workHoursEntityJpaRepository.findAll();
        List<WorkDateDto> workDateDtos = workHoursEntities.stream()
                .map(workHoursEntity -> new WorkDateDto(workHoursEntity.getId(), workHoursEntity.getDate(),
                        StringUtils.convertToIntegersByComma(workHoursEntity.getHours())))
                .collect(Collectors.toList());

        return workDateDtos;
    }

    public void deleteWorkHour(Integer id) {
        boolean exist = workHoursEntityJpaRepository.existsById(id);
        if (exist) {
            workHoursEntityJpaRepository.deleteById(id);

        }
    }
}
