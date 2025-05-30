package br.com.fiap.baitersburger.core.domain.ports.out.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;

import java.util.Optional;

public interface FindCustomerByCpfOutputPort {
    Optional<Customer> find(String cpf);
}
