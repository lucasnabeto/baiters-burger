package br.com.fiap.baitersburger.adapters.in.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequestDTO {

    @NotBlank
    private String cpf;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

}
