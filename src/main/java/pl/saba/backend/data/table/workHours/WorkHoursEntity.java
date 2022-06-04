package pl.saba.backend.data.table.workHours;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "workHours")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "work_date")
    private Date dateTimeStamp;

    @Column(name = "hours")
    private String hours;
}
