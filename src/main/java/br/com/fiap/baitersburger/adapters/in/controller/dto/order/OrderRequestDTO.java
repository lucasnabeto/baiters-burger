package br.com.fiap.baitersburger.adapters.in.controller.dto.order;

import br.com.fiap.baitersburger.core.domain.model.Product;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    @NotEmpty
    private List<Product> products;
}
