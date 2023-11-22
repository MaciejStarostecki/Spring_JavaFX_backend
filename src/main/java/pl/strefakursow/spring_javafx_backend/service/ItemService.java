package pl.strefakursow.spring_javafx_backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.strefakursow.spring_javafx_backend.dto.ItemSaveDto;
import pl.strefakursow.spring_javafx_backend.entity.Item;
import pl.strefakursow.spring_javafx_backend.entity.QuantityType;
import pl.strefakursow.spring_javafx_backend.entity.Warehouse;
import pl.strefakursow.spring_javafx_backend.repository.ItemRepository;
import pl.strefakursow.spring_javafx_backend.repository.QuantityTypeRepository;
import pl.strefakursow.spring_javafx_backend.repository.WarehouseRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final WarehouseRepository warehouseRepository;
    private final QuantityTypeRepository quantityTypeRepository;

    public Item saveItem(ItemSaveDto dto) {
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(dto.getIdWarehouse());
        Optional<QuantityType> quantityTypeOptional = quantityTypeRepository.findById(dto.getIdQuantityType());
        if (!warehouseOptional.isPresent() || !quantityTypeOptional.isPresent()) {
            throw new RuntimeException("Incorrect identifiers");
        }
        Warehouse warehouse = warehouseOptional.get();
        QuantityType quantityType = quantityTypeOptional.get();

        Item item = Item.of(dto);
        item.setQuantityType(quantityType);
        item.setWarehouse(warehouse);
        return itemRepository.save(item);
    }

}
