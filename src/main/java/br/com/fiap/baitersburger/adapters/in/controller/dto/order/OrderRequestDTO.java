package br.com.fiap.baitersburger.adapters.in.controller.dto.order;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    @NotEmpty
    private List<String> productsIds;

    public List<String> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<String> productsIds) {
        this.productsIds = productsIds;
    }
}
