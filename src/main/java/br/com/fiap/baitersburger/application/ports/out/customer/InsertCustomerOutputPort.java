package br.com.fiap.baitersburger.application.ports.out.customer;

import br.com.fiap.baitersburger.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
