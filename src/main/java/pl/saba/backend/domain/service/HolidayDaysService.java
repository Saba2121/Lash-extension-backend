package pl.saba.backend.domain.service;


import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.holidaydays.HolidayDaysEntity;
import pl.saba.backend.data.table.holidaydays.HolidayDaysEntityJpaRepository;
import pl.saba.backend.http.dtoweb.HolidayDto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayDaysService {

    private final HolidayDaysEntityJpaRepository holidayDaysEntityJpaRepository;

    public HolidayDaysService(HolidayDaysEntityJpaRepository holidayDaysEntityJpaRepository) {
        this.holidayDaysEntityJpaRepository = holidayDaysEntityJpaRepository;
    }

    public void addHolidayDays(Date date) {

        HolidayDaysEntity holidayDaysEntity = new HolidayDaysEntity(null, date);
        holidayDaysEntityJpaRepository.save(holidayDaysEntity);
    }

    public List<Date> getAllHolidayDays() {

        List<HolidayDaysEntity> holidayDatesEntities = holidayDaysEntityJpaRepository.findAll();
        List<Date> holidayDate = holidayDatesEntities.stream()
                .map(holidayDaysEntity -> holidayDaysEntity.getDate())
                .collect(Collectors.toList());
        return holidayDate;
    }

    public List<HolidayDto> getAllHolidayDates() {
        List<HolidayDaysEntity> holidayDaysEntities = holidayDaysEntityJpaRepository.findAll();
        List<HolidayDto> holidayDtos = holidayDaysEntities.stream()
                .map(holidayDaysEntity -> new HolidayDto(holidayDaysEntity.getId(), holidayDaysEntity.getDate()))
                .collect(Collectors.toList());
        return holidayDtos;

    }

    public void deleteHoliday(Integer id) {
        boolean exist = holidayDaysEntityJpaRepository.existsById(id);
        if (exist) {
            holidayDaysEntityJpaRepository.deleteById(id);
        }


    }

}

