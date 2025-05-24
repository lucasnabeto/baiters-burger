package br.com.fiap.baitersburger.core.application.ports.in.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;

public interface FindCustomerByCpfInputPort {
    Customer find(String cpf);
}
