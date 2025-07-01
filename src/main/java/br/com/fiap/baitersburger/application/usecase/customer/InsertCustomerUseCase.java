package br.com.fiap.baitersburger.application.usecase.customer;

import br.com.fiap.baitersburger.domain.model.Customer;

public interface InsertCustomerUseCase {
    void insert(Customer customer);
}
