package pl.strefakursow.spring_javafx_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.spring_javafx_backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
