package pl.strefakursow.spring_javafx_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWarehouse;

    @Column
    private String name;

//    @ManyToMany(mappedBy = "warehouses")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
    private List<Item> items;


}
