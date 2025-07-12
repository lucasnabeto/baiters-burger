package br.com.fiap.baitersburger.interfaceadapters.dto.request;

import br.com.fiap.baitersburger.infrastructure.web.validator.ValidCPF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerRequestDTO {
    @NotBlank
    @ValidCPF(message = "CPF must be valid and contain 11 digits.")
    private String cpf;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "The name must contain only letters and spaces.")
    private String name;

    @NotBlank
    @Email(message = "Email must be valid.")
    private String email;

}
