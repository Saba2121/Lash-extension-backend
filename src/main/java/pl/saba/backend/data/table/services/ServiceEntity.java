package pl.saba.backend.data.table.services;

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
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "lash_ext_name")
    private String lashExtName;

    @Column(name = "lash_ext_image_base_64", columnDefinition = "TEXT")
    private String lashExtImageBase64;

    @Column(name = "lash_ext_price")
    private String lashExtPrice;

    @Column(name = "lash_ext_time")
    private String lashExtTime;

    @Column(name = "lash_ext_variant")
    private String lashExtVariant;

    @Column(name = "effect_type")
    private String effectType;

}
