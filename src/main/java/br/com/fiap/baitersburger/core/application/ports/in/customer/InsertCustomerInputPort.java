package br.com.fiap.baitersburger.core.application.ports.in.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer);
}
