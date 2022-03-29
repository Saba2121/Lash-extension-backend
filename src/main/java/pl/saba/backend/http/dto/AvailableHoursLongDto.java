package pl.saba.backend.http.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvailableHoursLongDto {

    private Long dateTimeStamp;
    private List<Integer> hours;

}
