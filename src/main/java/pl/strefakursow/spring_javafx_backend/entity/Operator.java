package pl.strefakursow.spring_javafx_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Operator {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOperator;

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "idEmployee")
    Employee employee;
}
