package pl.saba.backend.domain.service;


import org.springframework.stereotype.Service;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.domain.model.ImageUtils;
import pl.saba.backend.http.dto.LashExtDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LashExtService {

    public List<LashExtDto> getStyles(EffectType effectType) {

        List<LashExtDto> styles = new ArrayList<>();

        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-1", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-2", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-3", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-4", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-5", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-6", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-7", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-8", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-9", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-10", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-11", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-12", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-13", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-14", EffectType.NATURAL));
        styles.add(new LashExtDto("1:1", ImageUtils.getImageInBase64(EffectType.NATURAL), "120 pln", "Approx. 120 min",
                "1:1-15", EffectType.NATURAL));
        styles.add(new LashExtDto("2D", ImageUtils.getImageInBase64(EffectType.LIGHT), "130 pln", "Approx. 120 min",
                "2D-1", EffectType.LIGHT));
        styles.add(new LashExtDto("2D", ImageUtils.getImageInBase64(EffectType.LIGHT), "130 pln", "Approx. 120 min",
                "2D-2", EffectType.LIGHT));
        styles.add(new LashExtDto("2D", ImageUtils.getImageInBase64(EffectType.LIGHT), "130 pln", "Approx. 120 min",
                "2D-3", EffectType.LIGHT));
        styles.add(new LashExtDto("2D", ImageUtils.getImageInBase64(EffectType.LIGHT), "130 pln", "Approx. 120 min",
                "2D-4", EffectType.LIGHT));
        styles.add(new LashExtDto("2D", ImageUtils.getImageInBase64(EffectType.LIGHT), "130 pln", "Approx. 120 min",
                "2D-5", EffectType.LIGHT));
        styles.add(new LashExtDto("3D", ImageUtils.getImageInBase64(EffectType.LIGHT), "140 pln", "Approx. 120 min",
                "3D-1", EffectType.LIGHT));
        styles.add(new LashExtDto("3D", ImageUtils.getImageInBase64(EffectType.LIGHT), "140 pln", "Approx. 120 min",
                "3D-2", EffectType.LIGHT));
        styles.add(new LashExtDto("3D", ImageUtils.getImageInBase64(EffectType.LIGHT), "140 pln", "Approx. 120 min",
                "3D-3", EffectType.LIGHT));
        styles.add(new LashExtDto("3D", ImageUtils.getImageInBase64(EffectType.LIGHT), "140 pln", "Approx. 120 min",
                "3D-4", EffectType.LIGHT));
        styles.add(new LashExtDto("3D", ImageUtils.getImageInBase64(EffectType.LIGHT), "140 pln", "Approx. 120 min",
                "3D-5", EffectType.LIGHT));
        styles.add(new LashExtDto("4D", ImageUtils.getImageInBase64(EffectType.LIGHT), "150 pln", "Approx. 120 min",
                "4D-1", EffectType.LIGHT));
        styles.add(new LashExtDto("4D", ImageUtils.getImageInBase64(EffectType.LIGHT), "150 pln", "Approx. 120 min",
                "4D-2", EffectType.LIGHT));
        styles.add(new LashExtDto("4D", ImageUtils.getImageInBase64(EffectType.LIGHT), "150 pln", "Approx. 120 min",
                "4D-3", EffectType.LIGHT));
        styles.add(new LashExtDto("4D", ImageUtils.getImageInBase64(EffectType.LIGHT), "150 pln", "Approx. 120 min",
                "4D-4", EffectType.LIGHT));
        styles.add(new LashExtDto("4D", ImageUtils.getImageInBase64(EffectType.LIGHT), "150 pln", "Approx. 120 min",
                "4D-5", EffectType.LIGHT));
        styles.add(new LashExtDto("5D", ImageUtils.getImageInBase64(EffectType.VOLUME), "160 pln", "Approx. 120 min",
                "5D-1", EffectType.VOLUME));
        styles.add(new LashExtDto("5D", ImageUtils.getImageInBase64(EffectType.VOLUME), "160 pln", "Approx. 120 min",
                "5D-2", EffectType.VOLUME));
        styles.add(new LashExtDto("5D", ImageUtils.getImageInBase64(EffectType.VOLUME), "160 pln", "Approx. 120 min",
                "5D-3", EffectType.VOLUME));
        styles.add(new LashExtDto("5D", ImageUtils.getImageInBase64(EffectType.VOLUME), "160 pln", "Approx. 120 min",
                "5D-4", EffectType.VOLUME));
        styles.add(new LashExtDto("5D", ImageUtils.getImageInBase64(EffectType.VOLUME), "160 pln", "Approx. 120 min",
                "5D-5", EffectType.VOLUME));
        styles.add(new LashExtDto("6D", ImageUtils.getImageInBase64(EffectType.VOLUME), "170 pln", "Approx. 120 min",
                "6D-1", EffectType.VOLUME));
        styles.add(new LashExtDto("6D", ImageUtils.getImageInBase64(EffectType.VOLUME), "170 pln", "Approx. 120 min",
                "6D-2", EffectType.VOLUME));
        styles.add(new LashExtDto("6D", ImageUtils.getImageInBase64(EffectType.VOLUME), "170 pln", "Approx. 120 min",
                "6D-3", EffectType.VOLUME));
        styles.add(new LashExtDto("6D", ImageUtils.getImageInBase64(EffectType.VOLUME), "170 pln", "Approx. 120 min",
                "6D-4", EffectType.VOLUME));
        styles.add(new LashExtDto("6D", ImageUtils.getImageInBase64(EffectType.VOLUME), "170 pln", "Approx. 120 min",
                "6D-5", EffectType.VOLUME));
        styles.add(new LashExtDto("7D", ImageUtils.getImageInBase64(EffectType.VOLUME), "180 pln", "Approx. 120 min",
                "7D-1", EffectType.VOLUME));
        styles.add(new LashExtDto("7D", ImageUtils.getImageInBase64(EffectType.VOLUME), "180 pln", "Approx. 120 min",
                "7D-2", EffectType.VOLUME));
        styles.add(new LashExtDto("7D", ImageUtils.getImageInBase64(EffectType.VOLUME), "180 pln", "Approx. 120 min",
                "7D-3", EffectType.VOLUME));
        styles.add(new LashExtDto("7D", ImageUtils.getImageInBase64(EffectType.VOLUME), "180 pln", "Approx. 120 min",
                "7D-4", EffectType.VOLUME));
        styles.add(new LashExtDto("7D", ImageUtils.getImageInBase64(EffectType.VOLUME), "180 pln", "Approx. 120 min",
                "7D-5", EffectType.VOLUME));
        styles.add(new LashExtDto("Kim effect", ImageUtils.getImageInBase64(EffectType.KIM), "190 pln", "Approx. 120 min",
                "KIM-1", EffectType.KIM));
        styles.add(new LashExtDto("Kim effect", ImageUtils.getImageInBase64(EffectType.KIM), "190 pln", "Approx. 120 min",
                "KIM-2", EffectType.KIM));
        styles.add(new LashExtDto("Kim effect", ImageUtils.getImageInBase64(EffectType.KIM), "190 pln", "Approx. 120 min",
                "KIM-3", EffectType.KIM));
        styles.add(new LashExtDto("Kim effect", ImageUtils.getImageInBase64(EffectType.KIM), "190 pln", "Approx. 120 min",
                "KIM,-4", EffectType.KIM));
        styles.add(new LashExtDto("Kim effect", ImageUtils.getImageInBase64(EffectType.KIM), "190 pln", "Approx. 120 min",
                "KIM-5", EffectType.KIM));
        styles.add(new LashExtDto("Kim effect", ImageUtils.getImageInBase64(EffectType.KIM), "190 pln", "Approx. 120 min",
                "KIM-6", EffectType.KIM));
        styles.add(new LashExtDto("Kim effect", ImageUtils.getImageInBase64(EffectType.KIM), "190 pln", "Approx. 120 min",
                "KIM-7", EffectType.KIM));

        List<LashExtDto> filterStyles = styles.stream()
                .filter(lashExtDto -> lashExtDto.getEffectType().equals(effectType))
                .collect(Collectors.toList());

        return filterStyles;
    }

}








