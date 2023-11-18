package pl.strefakursow.spring_javafx_backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.spring_javafx_backend.entity.Warehouse;
import pl.strefakursow.spring_javafx_backend.repository.WarehouseRepository;
import pl.strefakursow.spring_javafx_backend.repository.WarehouseRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseRepository warehouseRepository;

    @PostMapping("/warehouses")
    Warehouse newWarehouse(@RequestBody Warehouse newWarehouse) {
        return warehouseRepository.save(newWarehouse);
    }

    @GetMapping("/warehouses")
    public List<Warehouse> listWarehouse() {
        return warehouseRepository.findAll();
    }

    @DeleteMapping("/warehouses")
    ResponseEntity deleteWarehouse(@RequestBody Long idWarehouse) {
        warehouseRepository.deleteById(idWarehouse);
        return ResponseEntity.ok().build();
    }
    
}
