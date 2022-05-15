package pl.saba.backend.data.table.styles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "styles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StyleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "lashExtName")
    private String lashExtName;

    @Column(name = "lashExtImageBase64")
    private String lashExtImageBase64;

    @Column(name = "lashExtPrice")
    private String lashExtPrice;

    @Column(name = "lashExtTime")
    private String lashExtTime;

    @Column(name = "lashExtVariant")
    private String lashExtVariant;

    @Column(name = "effectType")
    private String effectType;


}
