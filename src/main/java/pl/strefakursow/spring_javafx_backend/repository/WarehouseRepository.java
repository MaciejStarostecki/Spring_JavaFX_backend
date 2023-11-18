package pl.strefakursow.spring_javafx_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.spring_javafx_backend.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
