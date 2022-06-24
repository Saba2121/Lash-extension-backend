package pl.saba.backend.data.table.visits;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface VisitEntityJpaRepository extends JpaRepository<VisitEntity, Integer> {

    List<VisitEntity> findAllByVisitDateAfterAndVisitDateBefore(Date from, Date to);

}
