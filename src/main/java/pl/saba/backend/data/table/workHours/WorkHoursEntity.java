package pl.saba.backend.data.table.workHours;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    //    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_timestamp")
    private Long dateTimeStamp;
//    private Integer dateTimeStamp;

    @Column(name = "hours")
    private String hours;
}
