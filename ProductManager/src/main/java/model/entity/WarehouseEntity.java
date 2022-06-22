package model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    @JsonIgnore
    private ProvinceEntity provinceEntity;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    @JsonIgnore
    private DistrictEntity districtEntity;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<WarehouseProductEntity> warehouseProductEntities;
}
