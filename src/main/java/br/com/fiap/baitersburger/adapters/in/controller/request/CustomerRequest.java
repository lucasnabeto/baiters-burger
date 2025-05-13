package br.com.fiap.baitersburger.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String cpf;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

}
