package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.visits.VisitEntity;
import pl.saba.backend.data.table.visits.VisitEntityJpaRepository;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.http.dto.VisitDto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitService {

    private final VisitEntityJpaRepository visitEntityJpaRepository;

    public VisitService(VisitEntityJpaRepository visitEntityJpaRepository) {
        this.visitEntityJpaRepository = visitEntityJpaRepository;
    }

    public void addVisit(VisitDto visitDto) {

        Date date = new Date(visitDto.getVisitTimestamp());

        VisitEntity visitEntity = new VisitEntity(null, visitDto.getName(), visitDto.getSurname(),
                visitDto.getNumberPhone(), date, visitDto.getEffectType().name(),
                visitDto.getVariant());

        visitEntityJpaRepository.save(visitEntity);
    }

    public List<VisitDto> getAllVisits() {

        String effectType = "";
        EffectType effectType1 = EffectType.valueOf(effectType);

        List<VisitEntity> visitEntities = visitEntityJpaRepository.findAll();
        List<VisitDto> visits = visitEntities.stream()
                .map(visitEntity -> new VisitDto(visitEntity.getName(), visitEntity.getSurname(),
                        visitEntity.getNumberPhone(), visitEntity.getVisitTimestamp().getTime(),
                        effectType1, visitEntity.getVariant()))
                .collect(Collectors.toList());
        return visits;
    }
}
