package pl.strefakursow.spring_javafx_backend.dto;

import lombok.Data;

@Data
public class ItemSaveDto {

    private String name;
    private Double quantity;
    private Long idQuantityType;
    private Long idWarehouse;
}
