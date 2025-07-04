package br.com.fiap.baitersburger.domain.port.out.gateway;

import br.com.fiap.baitersburger.domain.model.Customer;

import java.util.Optional;

public interface CustomerGateway {

    void insert(Customer customer);
    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByEmail(String email);

}
