package br.com.fiap.baitersburger.adapters.in.controller.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private String cpf;
    private String name;
    private String email;
}
