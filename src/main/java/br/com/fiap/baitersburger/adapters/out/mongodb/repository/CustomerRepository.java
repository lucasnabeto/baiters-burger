package br.com.fiap.baitersburger.adapters.out.mongodb.repository;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerEntity,String> {
    Optional<CustomerEntity> findByCpf(String cpf);
}
