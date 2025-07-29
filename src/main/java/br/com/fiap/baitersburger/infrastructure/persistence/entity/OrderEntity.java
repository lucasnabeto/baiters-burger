package br.com.fiap.baitersburger.infrastructure.persistence.entity;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "orders")
public class OrderEntity {
    @Id
    private String id;

    private List<ProductEntity> products;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private OrderStatus status;

    private CustomerEntity customer;

}
