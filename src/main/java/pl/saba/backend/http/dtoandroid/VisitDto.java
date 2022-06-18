package pl.saba.backend.http.dtoandroid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.saba.backend.domain.model.EffectType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitDto {

    private String name;
    private String surname;
    private String numberPhone;
    private Long visitTimestamp;
    private EffectType effectType;
    private String variant;


}
