package br.com.fiap.baitersburger.domain.port.in.usecase.customer;

import br.com.fiap.baitersburger.domain.model.Customer;

public interface FindCustomerByCpfUseCase {
    Customer find(String cpf);
}
