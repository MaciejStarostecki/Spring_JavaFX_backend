package pl.strefakursow.spring_javafx_backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.spring_javafx_backend.entity.QuantityType;
import pl.strefakursow.spring_javafx_backend.repository.QuantityTypeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/quantity_types")
    QuantityType newQuantityType(@RequestBody QuantityType newQuantityType) {
        return quantityTypeRepository.save(newQuantityType);
    }

    @GetMapping("/quantity_types")
    public List<QuantityType> listQuantityType() {
        return quantityTypeRepository.findAll();
    }

    @DeleteMapping("/quantity_types")
    ResponseEntity deleteQuantityType(@RequestBody Long idQuantityType) {
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }

}
