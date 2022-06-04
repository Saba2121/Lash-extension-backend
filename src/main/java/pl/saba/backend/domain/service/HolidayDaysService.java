package pl.saba.backend.domain.service;


import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.holidayDays.HolidayDaysEntity;
import pl.saba.backend.data.table.holidayDays.HolidayDaysEntityJpaRepository;

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

}

