package br.com.fiap.baitersburger.application.usecase.customer;

import br.com.fiap.baitersburger.domain.model.Customer;

public interface FindCustomerByCpfUseCase {
    Customer find(String cpf);
}
