package br.com.fiap.baitersburger.infrastructure.persistence.repository;

import br.com.fiap.baitersburger.domain.enums.Category;
import br.com.fiap.baitersburger.infrastructure.persistence.entity.ProductMySqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductMySqlRepository extends JpaRepository<ProductMySqlEntity, String> {
    List<ProductMySqlEntity> findByCategory(Category category);
}
