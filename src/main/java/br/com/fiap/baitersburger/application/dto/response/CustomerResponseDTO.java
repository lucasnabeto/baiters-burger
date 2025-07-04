package br.com.fiap.baitersburger.application.dto.response;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private String cpf;
    private String name;
    private String email;
}
