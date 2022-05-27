package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.visits.VisitEntity;
import pl.saba.backend.data.table.visits.VisitEntityJpaRepository;
import pl.saba.backend.http.dto.VisitDto;

@Service
public class VisitService {

    private final VisitEntityJpaRepository visitEntityJpaRepository;

    public VisitService(VisitEntityJpaRepository visitEntityJpaRepository) {
        this.visitEntityJpaRepository = visitEntityJpaRepository;
    }

    public void addVisit(VisitDto visitDto) {

        VisitEntity visitEntity = new VisitEntity(null, visitDto.getName(), visitDto.getSurname(),
                visitDto.getNumberPhone(), visitDto.getVisitTimestamp(), visitDto.getEffectType().name(),
                visitDto.getVariant());

        visitEntityJpaRepository.save(visitEntity);
    }

}
