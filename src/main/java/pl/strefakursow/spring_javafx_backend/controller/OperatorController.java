package pl.strefakursow.spring_javafx_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.spring_javafx_backend.entity.Operator;
import pl.strefakursow.spring_javafx_backend.repository.OperatorRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorRepository operatorRepository;

    @PostMapping("/operators")
    Operator newOperator(@RequestBody Operator newOperator) {
        return operatorRepository.save(newOperator);
    }

    @GetMapping("/operators")
    public List<Operator> listOperator() {
        return operatorRepository.findAll();
    }

    @DeleteMapping("/operators")
    ResponseEntity deleteOperator(@RequestBody Long idOperator) {
        operatorRepository.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }

}
