package br.com.fiap.baitersburger.adapters.in.controller.dto.order;

import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.core.domain.model.Customer;
import br.com.fiap.baitersburger.core.domain.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponseDTO {
    private List<Product> products;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private Customer customer;
}
