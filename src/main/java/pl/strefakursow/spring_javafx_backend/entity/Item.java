package pl.strefakursow.spring_javafx_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.strefakursow.spring_javafx_backend.dto.ItemSaveDto;

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

    public static Item of(ItemSaveDto dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        return item;
    }
}
