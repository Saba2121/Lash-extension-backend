package pl.saba.backend.http.dtoweb;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDateDto {

    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private List<Integer> hours;
}

