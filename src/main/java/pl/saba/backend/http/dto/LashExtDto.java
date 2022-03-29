package pl.saba.backend.http.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.saba.backend.domain.model.EffectType;

@Getter
@AllArgsConstructor
public class LashExtDto {
    private String lashExtName;
    private String lashExtImageBase64;
    private String lashExtPrice;
    private String lashExtTime;
    private String lashExtVariant;
    private EffectType effectType;

}
