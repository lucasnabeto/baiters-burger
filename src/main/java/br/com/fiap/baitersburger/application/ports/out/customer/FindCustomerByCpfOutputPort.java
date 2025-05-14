package br.com.fiap.baitersburger.application.ports.out.customer;

import br.com.fiap.baitersburger.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByCpfOutputPort {

    Optional<Customer> find(String cpf);

}
