package br.com.fiap.baitersburger.infrastructure.persistence.entity;

import br.com.fiap.baitersburger.domain.enums.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Data
@Table(name="products")
public class ProductMySqlEntity {
    @Id
    private String id;

    private String productName;

    private BigDecimal price;

    private Category category;

    private List<String> imagesUrls;

    private String description;
}
