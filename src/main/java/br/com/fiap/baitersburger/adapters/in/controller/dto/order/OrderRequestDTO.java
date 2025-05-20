package br.com.fiap.baitersburger.adapters.in.controller.dto.order;

import br.com.fiap.baitersburger.core.domain.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private List<Product> products;
}
