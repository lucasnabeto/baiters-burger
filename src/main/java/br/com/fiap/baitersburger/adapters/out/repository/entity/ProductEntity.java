package br.com.fiap.baitersburger.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document(collection = "products")
public class ProductEntity {
    @Id
    private String id;
    private String productName;
    private BigDecimal price;
    private String category;
    private List<String> imagesUrls;
    private String description;
}
