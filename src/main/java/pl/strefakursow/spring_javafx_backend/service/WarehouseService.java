package pl.strefakursow.spring_javafx_backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.strefakursow.spring_javafx_backend.dto.ItemDto;
import pl.strefakursow.spring_javafx_backend.dto.WarehouseDto;
import pl.strefakursow.spring_javafx_backend.dto.WarehouseModuleDto;
import pl.strefakursow.spring_javafx_backend.entity.Warehouse;
import pl.strefakursow.spring_javafx_backend.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseModuleDto getWarehouseModuleData() {
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        List<WarehouseDto> warehouseDtoList = warehouseList.stream()
                .map(WarehouseDto::of)
                .toList();
        List<ItemDto> itemDtoList = warehouseList.get(0).getItems().stream()
                .map(ItemDto::of)
                .toList();
        WarehouseDto selectedWarehouseDto = WarehouseDto.of(warehouseList.get(0));
        WarehouseModuleDto warehouseModuleDto = new WarehouseModuleDto(selectedWarehouseDto, warehouseDtoList, itemDtoList);
        return warehouseModuleDto;
    }

    public WarehouseModuleDto getWarehouseModuleData(Long idWarehouse) {
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        List<WarehouseDto> warehouseDtoList = warehouseList.stream()
                .map(WarehouseDto::of)
                .toList();
        Optional<Warehouse> optionalWarehouse = warehouseList.stream().filter(x -> idWarehouse.equals(x.getIdWarehouse())).findFirst();
        Warehouse selectedWarehouse = optionalWarehouse.get();
        List<ItemDto> itemDtoList = selectedWarehouse.getItems().stream()
                .map(ItemDto::of)
                .toList();
        WarehouseModuleDto warehouseModuleDto = new WarehouseModuleDto(WarehouseDto.of(selectedWarehouse), warehouseDtoList, itemDtoList);
        return warehouseModuleDto;
    }

}
