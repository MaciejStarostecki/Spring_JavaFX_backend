package pl.strefakursow.spring_javafx_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idWarehouse;

    @Column
    private String name;

    @ManyToMany(mappedBy = "warehouses")
    private Set<Item> items;

}
