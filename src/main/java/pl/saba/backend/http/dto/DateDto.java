package pl.saba.backend.http.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class DateDto {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public DateDto(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
