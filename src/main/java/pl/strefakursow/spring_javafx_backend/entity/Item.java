package pl.strefakursow.spring_javafx_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @Column
    private String name;

    @Column
    private Double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "idQuantityType")
    QuantityType quantityType;

//    @ManyToMany
//    @JoinTable(
//            name = "item_warehouse",
//            joinColumns = @JoinColumn(name = "idItem"),
//            inverseJoinColumns = @JoinColumn(name = "idWarehouse")
//    )
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idWarehouse")
    private Warehouse warehouse;

}
