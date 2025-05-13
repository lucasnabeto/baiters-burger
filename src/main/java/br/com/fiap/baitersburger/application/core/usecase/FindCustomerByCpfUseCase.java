package br.com.fiap.baitersburger.application.core.usecase;

import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.exceptions.CustomerNotFoundException;
import br.com.fiap.baitersburger.application.ports.in.FindCustomerByCpfInputPort;
import br.com.fiap.baitersburger.application.ports.out.FindCustomerByCpfOutputPort;

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
