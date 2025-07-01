package br.com.fiap.baitersburger.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    @NotEmpty
    private List<String> productsIds;

    private String customerCpf;

    public List<String> getProductsIds() {
        return productsIds;
    }

    public String getCustomerCpf() {
        return customerCpf;
    }

    public void setProductsIds(List<String> productsIds) {
        this.productsIds = productsIds;
    }
}
