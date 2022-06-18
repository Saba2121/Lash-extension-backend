package pl.saba.backend.http.dtoweb;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AvailableHoursStringDto {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private List<Integer> hours;

}
