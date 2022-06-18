package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.visits.VisitEntity;
import pl.saba.backend.data.table.visits.VisitEntityJpaRepository;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.http.dtoandroid.VisitDto;
import pl.saba.backend.http.dtoweb.VisitDateDto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitService {

    private final VisitEntityJpaRepository visitEntityJpaRepository;

    public VisitService(VisitEntityJpaRepository visitEntityJpaRepository) {
        this.visitEntityJpaRepository = visitEntityJpaRepository;
    }

    public List<VisitDateDto> getAllVisits() {
        List<VisitEntity> visitEntities = visitEntityJpaRepository.findAll();
        List<VisitDateDto> visitDateDtos = visitEntities.stream()
                .map(visitEntity -> new VisitDateDto(visitEntity.getId(), visitEntity.getName(), visitEntity.getSurname(),
                        visitEntity.getNumberPhone(), visitEntity.getVisitDate(),
                        EffectType.valueOf(visitEntity.getEffectType()), visitEntity.getVariant(), visitEntity.getCreatedAt()))
                .collect(Collectors.toList());
        return visitDateDtos;
    }

    public void addVisit(VisitDto visitDto) {

        Date date = new Date(visitDto.getVisitTimestamp());

        VisitEntity visitEntity = new VisitEntity(null, visitDto.getName(), visitDto.getSurname(),
                visitDto.getNumberPhone(), date, visitDto.getEffectType().name(),
                visitDto.getVariant(), new Date());

        visitEntityJpaRepository.save(visitEntity);
    }

    public void deleteVisit(Integer id) {

        boolean exist = visitEntityJpaRepository.existsById(id);
        if (exist) {
            visitEntityJpaRepository.deleteById(id);

        }
    }


}
