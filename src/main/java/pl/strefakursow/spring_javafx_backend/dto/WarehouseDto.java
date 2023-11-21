package pl.strefakursow.spring_javafx_backend.dto;

import lombok.Data;
import pl.strefakursow.spring_javafx_backend.entity.Warehouse;

@Data
public class WarehouseDto {

    private Long idWarehouse;
    private String name;

    public static WarehouseDto of(Warehouse warehouse) {
        WarehouseDto dto = new WarehouseDto();
        dto.setIdWarehouse(warehouse.getIdWarehouse());
        dto.setName(warehouse.getName());
        return dto;
    }
}
