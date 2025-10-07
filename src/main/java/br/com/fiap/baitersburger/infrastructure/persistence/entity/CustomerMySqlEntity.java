package br.com.fiap.baitersburger.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="customers")
public class CustomerMySqlEntity {
    @Id
    private String id;

    private String cpf;

    private String name;

    private String email;
}
