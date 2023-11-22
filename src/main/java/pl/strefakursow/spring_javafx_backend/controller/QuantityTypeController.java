package pl.strefakursow.spring_javafx_backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.spring_javafx_backend.dto.QuantityTypeDto;
import pl.strefakursow.spring_javafx_backend.entity.QuantityType;
import pl.strefakursow.spring_javafx_backend.repository.QuantityTypeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/")
    public QuantityType newQuantityType(@RequestBody QuantityType newQuantityType) {
        return quantityTypeRepository.save(newQuantityType);
    }

    @GetMapping("/quantity_types")
    public List<QuantityTypeDto> listQuantityType() {
        return quantityTypeRepository.findAll().stream().map(QuantityTypeDto::of).toList();
    }

    @DeleteMapping("/quantity_types")
    public ResponseEntity deleteQuantityType(@RequestBody Long idQuantityType) {
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
    }

}
