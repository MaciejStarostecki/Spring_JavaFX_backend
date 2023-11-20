package pl.strefakursow.spring_javafx_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.strefakursow.spring_javafx_backend.dto.EmployeeDto;

@Data
@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String salary;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmployee")
    Operator operator;

    public static Employee of(EmployeeDto newEmployee) {
        Employee employee = new Employee();
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setSalary(newEmployee.getSalary());
        return employee;
    }

}
