package br.com.fiap.baitersburger.interfaceadapters.dto.response;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.model.Product;
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
