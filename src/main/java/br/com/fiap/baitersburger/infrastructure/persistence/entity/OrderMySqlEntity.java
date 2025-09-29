package br.com.fiap.baitersburger.infrastructure.persistence.entity;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name="orders")
public class OrderMySqlEntity {

    @Id
    private String id;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductMySqlEntity> products;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerMySqlEntity customer;
}
