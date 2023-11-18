package pl.strefakursow.spring_javafx_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.spring_javafx_backend.dto.OperatorAuthenticationResultDto;
import pl.strefakursow.spring_javafx_backend.dto.OperatorCredentialsDto;
import pl.strefakursow.spring_javafx_backend.entity.Operator;
import pl.strefakursow.spring_javafx_backend.repository.OperatorRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorRepository operatorRepository;

    @PostMapping("/operators")
    public Operator newOperator(@RequestBody Operator newOperator) {
        return operatorRepository.save(newOperator);
    }

    @GetMapping("/operators")
    public List<Operator> listOperator() {
        return operatorRepository.findAll();
    }

    @DeleteMapping("/operators")
    public ResponseEntity deleteOperator(@RequestBody Long idOperator) {
        operatorRepository.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify_operator_credentials")
    public OperatorAuthenticationResultDto verifyOperatorCredentials(@RequestBody OperatorCredentialsDto operatorCredentialsDto) {
        Optional<Operator> loginOperator = operatorRepository.findByLogin(operatorCredentialsDto.getLogin());
        if (!loginOperator.isPresent()) {
            return OperatorAuthenticationResultDto.createUnauthenticated();
        }

        Operator operator = loginOperator.get();
        if(!operator.getPassword().equals(operatorCredentialsDto.getPassword())) {
            return OperatorAuthenticationResultDto.createUnauthenticated();
        }

        return OperatorAuthenticationResultDto.of(operator);
    }

}
