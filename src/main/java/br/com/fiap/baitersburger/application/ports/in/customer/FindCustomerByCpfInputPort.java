package br.com.fiap.baitersburger.application.ports.in.customer;

import br.com.fiap.baitersburger.application.core.domain.Customer;

public interface FindCustomerByCpfInputPort {
    Customer find(String cpf);
}
