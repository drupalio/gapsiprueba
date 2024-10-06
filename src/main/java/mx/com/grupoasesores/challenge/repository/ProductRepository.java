package mx.com.grupoasesores.challenge.repository;

import mx.com.grupoasesores.challenge.repository.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
