package pl.saba.backend.data.table.visits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "visits")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "number_phone")
    private String numberPhone;

    //    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "visit_timestamp")
    private Long visitTimestamp;
//    private Date visitTimestamp;

    @Column(name = "effect_type")
    private String effectType;

    @Column(name = "variant")
    private String variant;
}
