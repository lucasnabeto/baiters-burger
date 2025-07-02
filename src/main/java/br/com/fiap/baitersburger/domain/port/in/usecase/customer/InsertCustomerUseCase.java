package br.com.fiap.baitersburger.domain.port.in.usecase.customer;

import br.com.fiap.baitersburger.domain.model.Customer;

public interface InsertCustomerUseCase {
    void insert(Customer customer);
}
