package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.services.ServiceEntity;
import pl.saba.backend.data.table.services.ServiceEntityJpaRepository;
import pl.saba.backend.http.dto.LashExtDto;

@Service
public class ServiceService {

    private final ServiceEntityJpaRepository serviceEntityJpaRepository;

    public ServiceService(ServiceEntityJpaRepository serviceEntityJpaRepository) {
        this.serviceEntityJpaRepository = serviceEntityJpaRepository;
    }

    public void addStyle(LashExtDto lashExtDto) {

        ServiceEntity serviceEntity = new ServiceEntity(null, lashExtDto.getLashExtName(), lashExtDto.getLashExtImageBase64(),
                lashExtDto.getLashExtPrice(), lashExtDto.getLashExtTime(), lashExtDto.getLashExtVariant(),
                lashExtDto.getEffectType().name());

        serviceEntityJpaRepository.save(serviceEntity);

    }
//    public List<LashExtDto> getAllFilteredStyles(EffectType effectType){
//
//        List<ServiceEntity> serviceEntities = serviceEntityJpaRepository.findAll();
//        List<LashExtDto> effectType = serviceEntities.stream()
//                .map(serviceEntity -> serviceEntity.getEffectType())
//                .collect(Collectors.toList());
//        return effectType;
//
//
//    }

}
