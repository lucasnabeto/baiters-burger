package br.com.fiap.baitersburger.infrastructure.persistence.repository;

import br.com.fiap.baitersburger.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerMongoRepository extends MongoRepository<CustomerEntity,String> {
    Optional<CustomerEntity> findByCpf(String cpf);

    Optional<CustomerEntity> findByEmail(String email);


}
