package br.com.fiap.baitersburger.core.domain.ports.out.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;

import java.util.Optional;

public interface FindCustomerByEmailOutputPort {
    Optional<Customer> findByEmail(String email);
}
