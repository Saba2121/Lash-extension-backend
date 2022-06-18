package pl.saba.backend.http.dtoweb;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.saba.backend.domain.model.EffectType;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDateDto {
    private Integer id;
    private String name;
    private String surname;
    private String numberPhone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date visitTimestamp;
    private EffectType effectType;
    private String variant;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

}
