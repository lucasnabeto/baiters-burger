package br.com.fiap.baitersburger.infrastructure.persistence.repository;

import br.com.fiap.baitersburger.infrastructure.persistence.entity.CustomerMySqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerMySqlRepository extends JpaRepository<CustomerMySqlEntity, String> {


    Optional<CustomerMySqlEntity> findByCpf(String cpf);

    Optional<CustomerMySqlEntity> findByEmail(String email);
}
