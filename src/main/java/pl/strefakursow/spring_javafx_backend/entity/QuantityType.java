package pl.strefakursow.spring_javafx_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class QuantityType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQuantityType;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quantityType")
    private List<Item> items;

}
