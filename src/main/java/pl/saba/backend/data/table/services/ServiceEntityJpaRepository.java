package pl.saba.backend.data.table.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceEntityJpaRepository extends JpaRepository<ServiceEntity, Integer> {

    List<ServiceEntity> findAllByEffectType(String effectType);

}
