package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.data.table.styles.StyleEntity;
import pl.saba.backend.data.table.styles.StyleEntityJpaRepository;
import pl.saba.backend.http.dto.LashExtDto;

@Service
public class StyleService {

    private StyleEntityJpaRepository styleEntityJpaRepository;

    public StyleService(StyleEntityJpaRepository styleEntityJpaRepository) {
        this.styleEntityJpaRepository = styleEntityJpaRepository;
    }

    public void addStyle(LashExtDto lashExtDto) {

        StyleEntity styleEntity = new StyleEntity(null, lashExtDto.getLashExtName(), lashExtDto.getLashExtImageBase64(),
                lashExtDto.getLashExtPrice(), lashExtDto.getLashExtTime(), lashExtDto.getLashExtVariant(),
                lashExtDto.getEffectType().name());

        styleEntityJpaRepository.save(styleEntity);

    }
}
