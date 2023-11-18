package pl.strefakursow.spring_javafx_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmployee;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmployee")
    Operator operator;

}
