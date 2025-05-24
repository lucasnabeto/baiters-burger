package br.com.fiap.baitersburger.core.application.usecase.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;
import br.com.fiap.baitersburger.core.exceptions.CustomerNotFoundException;
import br.com.fiap.baitersburger.core.application.ports.in.customer.FindCustomerByCpfInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.FindCustomerByCpfOutputPort;

public class FindCustomerByCpfUseCase implements FindCustomerByCpfInputPort {

    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;

    public FindCustomerByCpfUseCase(FindCustomerByCpfOutputPort findCustomerByCpfOutputPort) {
        this.findCustomerByCpfOutputPort  = findCustomerByCpfOutputPort;
    }

    @Override
    public Customer find(String cpf) {
        return findCustomerByCpfOutputPort.find(cpf).orElseThrow(CustomerNotFoundException::new);
    }
}
