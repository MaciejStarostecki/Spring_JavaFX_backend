package pl.strefakursow.spring_javafx_backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.spring_javafx_backend.dto.WarehouseModuleDto;
import pl.strefakursow.spring_javafx_backend.entity.Warehouse;
import pl.strefakursow.spring_javafx_backend.repository.WarehouseRepository;
import pl.strefakursow.spring_javafx_backend.repository.WarehouseRepository;
import pl.strefakursow.spring_javafx_backend.service.WarehouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseService warehouseService;

    @PostMapping("/warehouses")
    public Warehouse newWarehouse(@RequestBody Warehouse newWarehouse) {
        return warehouseRepository.save(newWarehouse);
    }

    @GetMapping("/warehouses")
    public List<Warehouse> listWarehouse() {
        return warehouseRepository.findAll();
    }

    @DeleteMapping("/warehouses")
    public ResponseEntity deleteWarehouse(@RequestBody Long idWarehouse) {
        warehouseRepository.deleteById(idWarehouse);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/warehouse_module_data")
    public WarehouseModuleDto getWarehouseModuleData(@RequestParam Optional<String> idWarehouse) {
        if (idWarehouse.isPresent()) {
            return warehouseService.getWarehouseModuleData(Long.parseLong(idWarehouse.get()));
        }
        return warehouseService.getWarehouseModuleData();
    }
    
}
