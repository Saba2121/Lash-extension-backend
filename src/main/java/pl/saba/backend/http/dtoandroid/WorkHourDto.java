package pl.saba.backend.http.dtoandroid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkHourDto {

    private Long dateTimeStamp;
    private List<Integer> hours;

}
