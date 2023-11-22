package pl.strefakursow.spring_javafx_backend.dto;

import lombok.Data;
import pl.strefakursow.spring_javafx_backend.entity.QuantityType;

@Data
public class QuantityTypeDto {

    private Long idQuantityType;
    private String name;

    public static QuantityTypeDto of(QuantityType quantityType) {

        QuantityTypeDto dto = new QuantityTypeDto();
        dto.setName(quantityType.getName());
        dto.setIdQuantityType(quantityType.getIdQuantityType());
        return dto;

    }

}
