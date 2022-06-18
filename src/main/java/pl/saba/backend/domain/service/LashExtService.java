package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.services.ServiceEntity;
import pl.saba.backend.data.table.services.ServiceEntityJpaRepository;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.http.dtoandroid.LashExtDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LashExtService {

    private final ServiceEntityJpaRepository serviceEntityJpaRepository;

    public LashExtService(ServiceEntityJpaRepository serviceEntityJpaRepository) {
        this.serviceEntityJpaRepository = serviceEntityJpaRepository;
    }

    public void addStyle(LashExtDto lashExtDto) {

        ServiceEntity serviceEntity = new ServiceEntity(null, lashExtDto.getLashExtName(), lashExtDto.getLashExtImageBase64(),
                lashExtDto.getLashExtPrice(), lashExtDto.getLashExtTime(), lashExtDto.getLashExtVariant(),
                lashExtDto.getEffectType().name());

        serviceEntityJpaRepository.save(serviceEntity);

    }

    public void deleteStyle(Integer id) {
        boolean exist = serviceEntityJpaRepository.existsById(id);
        if (exist) {
            serviceEntityJpaRepository.deleteById(id);

        }
    }

    public List<LashExtDto> getAllFilteredStyles(EffectType effectType) {

        List<ServiceEntity> serviceEntities = serviceEntityJpaRepository.findAllByEffectType(effectType.name());
        List<LashExtDto> lashExtDtoList = serviceEntities.stream()
                .map(serviceEntity -> new LashExtDto(serviceEntity.getLashExtName(), serviceEntity.getLashExtImageBase64(),
                        serviceEntity.getLashExtPrice(), serviceEntity.getLashExtTime(),
                        serviceEntity.getLashExtVariant(), effectType))
                .collect(Collectors.toList());
        return lashExtDtoList;


    }

}
