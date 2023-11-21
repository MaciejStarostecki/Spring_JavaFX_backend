package pl.strefakursow.spring_javafx_backend.dto;

import lombok.Data;
import pl.strefakursow.spring_javafx_backend.entity.Item;

@Data
public class ItemDto {

    private Long idItem;
    private String name;
    private Double quantity;
    private String quantityType;

    public static ItemDto of(Item item) {
        ItemDto dto = new ItemDto();
        dto.setIdItem(item.getIdItem());
        dto.setName(item.getName());
        dto.setQuantity(item.getQuantity());
        dto.setQuantityType(item.getQuantityType().getName());
        System.out.println(dto + "1");
        return dto;
    }

}
