package br.com.fiap.baitersburger.core.domain.ports.out.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
