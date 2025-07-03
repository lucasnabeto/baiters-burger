package br.com.fiap.baitersburger.domain.port.out.repository;

import br.com.fiap.baitersburger.domain.model.Customer;

import java.util.Optional;

public interface CustomerDataSource {

    void insert(Customer customer);
    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByEmail(String email);

}
