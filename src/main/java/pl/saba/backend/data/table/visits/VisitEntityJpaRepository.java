package pl.saba.backend.data.table.visits;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitEntityJpaRepository extends JpaRepository<VisitEntity, Integer> {


//     public Boolean findByDateVisitExistEquals(Long date);


}
