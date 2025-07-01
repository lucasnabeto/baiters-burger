package br.com.fiap.baitersburger.infrastructure.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private String id;

    private String cpf;

    private String name;

    private String email;
}
