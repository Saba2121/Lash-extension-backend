package pl.saba.backend.data.table.holidaydays;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "holidayDays")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HolidayDaysEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "holiday_date")
    private Date date;

}
