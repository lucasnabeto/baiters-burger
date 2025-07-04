package br.com.fiap.baitersburger.application.usecase.customer;

import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;

public class FindCustomerByCpfUseCaseImpl implements FindCustomerByCpfUseCase {

    private final CustomerGateway customerGateway;

    public FindCustomerByCpfUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Customer find(String cpf) {
        return customerGateway.findByCpf(cpf).orElseThrow(() -> new NotFoundException(ExceptionMessages.CUSTOMER_NOT_FOUND));
    }
}
